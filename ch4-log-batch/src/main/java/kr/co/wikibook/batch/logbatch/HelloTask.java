package kr.co.wikibook.batch.logbatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloTask implements Tasklet {
  private final Logger log = LoggerFactory.getLogger(HelloTask.class);
  private int repetitions = 0;

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
    if (repetitions < 10) {
      log.info("Hello Batch : {}", repetitions);
      repetitions++;
      return RepeatStatus.CONTINUABLE;
    }
    return RepeatStatus.FINISHED;
  }
}
