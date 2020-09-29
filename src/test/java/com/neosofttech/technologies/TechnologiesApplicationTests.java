package com.neosofttech.technologies;

import com.fasterxml.jackson.databind.ObjectMapper;
import static com.google.common.base.CharMatcher.is;
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
import static io.netty.util.internal.SystemPropertyUtil.get;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@AutoConfigureMockMvc
@ContextConfiguration(classes = {WebfluxRestController.class})
@WebMvcTest
class TechnologiesApplicationTests {

        @Test
        void contextLoads() {
        }
        
        private MockMvc mockMvc;
        
        @Autowired
        private WebApplicationContext wac;
 
	@MockBean
	private EmployeeService service;
        
         @Mock
         EmployeeRepository mockRepository;
        
         @BeforeEach
         public void setup() {
         DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
         this.mockMvc = builder.build();         
         }
         
          private static final int id = 1;
          private static final String name = "vikash";
        
         @Test
	 public void testAddEmployee() throws Exception {
             
             Employee emplyoee=new Employee();
             emplyoee.setId(id);
             
             emplyoee.setName(name);
             
             when(mockRepository.save(any(Employee.class))).thenReturn(emplyoee);
             
             when(service.addEmplyoee(emplyoee)).thenReturn(Mono.just(emplyoee));
             
             assertNotNull(mockRepository.save(emplyoee));
             
             assertNotNull(emplyoee.getName());

             assertEquals(emplyoee.getId(), 1);
             
             Mockito.verify(mockRepository, times(1)).save(emplyoee);
              
                 MvcResult result = mockMvc
		.perform(post("/Webflux/addEmplyoee").content(asJsonString(emplyoee))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

             String resultstring = result.getResponse().getContentAsString();
             assertNotNull(resultstring);
                        
           }
         
             @Test
	     public void testFindAllEmployee() throws Exception 
             {
                               
             Employee emplyoee1 = new Employee(1,"vikash");
             Employee emplyoee2 = new Employee(2,"vikash");
              
             List<Employee> emplyoee_list = new ArrayList<Employee>();
             
             emplyoee_list.add(emplyoee1);
             emplyoee_list.add(emplyoee2);
             
             when(mockRepository.findAll()).thenReturn(emplyoee_list);
             
             assertNotNull(mockRepository.findAll());

             Mockito.verify(mockRepository, times(1)).findAll();

             
            
                                                                                           
           }
             
             
         
         public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}         
        
        
	}
        
       

      

