package com.neosofttech.technologies;

import com.neosofttech.technologies.controller.WebfluxRestController;
import com.neosofttech.technologies.dto.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;
import com.neosofttech.technologies.repository.EmployeeRepository;
import com.neosofttech.technologies.service.EmployeeService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
class TechnologiesApplicationTests {

        @Test
        void contextLoads() {
        }

	@MockBean
	private EmployeeService service;
        
        @Mock
        EmployeeRepository mockRepository;
                   
        @Test
	public void testFindAllEmployee() {
             Employee emplyoee = new Employee(1,"vikash");
             when(mockRepository.save(any(Employee.class))).thenReturn(emplyoee);
                     assertEquals(emplyoee.getId(), 1);

	}

      
 }
