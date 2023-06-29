package mz.course.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.redis.RedisLock;
import mz.course.application.domain.dto.CourseApplicationDto;
import mz.course.application.domain.entity.CourseApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseApplicationService {

	private final RedisLock redisLock;
	private RedisTemplate<String, Object> redisTemplate;

	// TODO 카프카 PUB 처리
	public void registerCourseApplication(CourseApplicationDto courseApplicationDto) {

	}

	public CourseApplication findCourseApplication(String id) {
		return null;
	}

	public CourseApplication getCourseApplicationResult(String id, String studentId) {
		return null;
	}


	public void checkCourseApplication(String studentId, String courseItemTeacherId) throws InterruptedException {

		while(!redisLock.lock(courseItemTeacherId)) {
			Thread.sleep(100);
		}

		try{
			Integer count = (Integer) redisTemplate.opsForValue().get(courseItemTeacherId+"count");
			if(count == null) {
				// TODO 정원 구해서 넣기
				count = 20;
				redisTemplate.opsForValue().set(courseItemTeacherId+"count", count);
			}
			Integer waitingNo = 0;
			if( count > 0 ) {
				// 수강신청 성공
				redisTemplate.opsForValue().set(courseItemTeacherId+"count", count-1);
			} else {
				// 수강신청 실패한 경우 대기번호
				waitingNo = -(count-1);
			}

		} finally {
			redisLock.unlock(courseItemTeacherId);
		}

		// TODO 수강신청 성공여부와 대기번호를 이벤트 발생 (대기번호 0이면 성공)
	}
}
