package batch;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class IntervalJob implements Job {
	private static int count = 0;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//주기적으로 자동으로 수행할 일(을 여기에 만들면 됨)
		count++; //일을 할때마다 IntervalJob이 일한 횟수를 결과로 출력해주겠다.
		System.out.println(Calendar.getInstance().getTime() + " IntervalJob - " + count);
	}

}







