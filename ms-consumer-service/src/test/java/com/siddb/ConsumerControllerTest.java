package com.siddb;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.siddb.controller.ConsumerController;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
    classes = {ConsumerController.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class,
    FeignAutoConfiguration.class})

public class ConsumerControllerTest {

  @InjectMocks
  private ConsumerController controller;

  @BeforeAll
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  // @Test
  public void contextLoads() {}

  // @Test
  public void test_render_success() throws Exception {
    // Assertions.assertEquals(HttpStatus.OK, object.getStatusCode(), "OK Status");
  }

}
