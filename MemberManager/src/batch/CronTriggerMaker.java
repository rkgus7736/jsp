package batch;

import org.quartz.CronScheduleBuilder;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerMaker {
	private String timer; //timer가 문자열인 이유는 크론(Cron)표현식이 들어가서
	private Class<? extends Job> job;
	private Scheduler scheduler; 
	
	public CronTriggerMaker(String timer, Class<? extends Job> job) {
		super();
		this.timer = timer;
		this.job = job;
	}
	
	public void createTrigger() {
		SchedulerFactory factory;
		//스케쥴러를 필드 선언 해줘야함
		Scheduler scheduler;
		
		//실제로 일 할 Job 생성
		JobDetail jobDetail =JobBuilder.newJob(job).withIdentity(job.getName(),"group").build();
		
		//CronTrigger 생성
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group").
				withSchedule(CronScheduleBuilder.cronSchedule(timer)).build();
		//scheduler가 일을 시키는 애
		factory = new StdSchedulerFactory();
		try {
			scheduler = factory.getScheduler();
			scheduler.start();
			//JobDetail, CronTrigger를 스케쥴러에 등록 (일을 할 두가지를 지정해주면 됨)
			scheduler.scheduleJob(jobDetail,cronTrigger);
			//scheduler.clear(); : 종료하는 법 1
			//scheduler.shutdown(); // 스케쥴러 종료 2 (더 옳은 방법)
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		
	}
	public void shutdownScheduler() {
		try {
			//스케줄러 종료
			scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	//run as의 java application으로 실행
	public static void main(String[] args) {
		//js = JobScheduler의 줄임말 , 크론식은 띄어쓰기로 구분함, * : 모든 값을 의미 (와일드카드)
		//반복 실행할때 무슨 일을 할지 ()안에 있는 Cron식을 바꿔주면 됨
		CronTriggerMaker js = new CronTriggerMaker("* * * * * ?", IntervalJob.class);
		js.createTrigger();
	}
	/*
	 * 크론 표현식 : 초 분 시 일 월 요일 년도
	 * 	초 : 0~59,   * , /
	 * 	분 : 0~59,   * , /
	 *	시 : 0~23,   * , /
	 * 	일 : 1~31,   * , / L W ?
	 * 	월 : 1~12,   * , /
	 *  요일 : 0~6 , SUN ~ SAT    , * ? / L #
	 *  년도 : 비우거나 1970 ~ 2099  , - *  /
	 *     
	 *     
	 *  * : 모든 값
	 *  ? : 특정한 값이 없음
	 *  - : 범위   SUN-SAT
	 *  / : 시작시간 / 단위
	 *  , : 특정 값일때만
	 *  
	 *  0/5 * * * * ?  --> 5초마다
	 *  0 0/5 * * * ?  --> 5분 마다
	 *  0 22 23 ? * *  --> 23시 22분 0초 마다 실행
	 *  http://www.cronmaker.com/
	 */
	
}









