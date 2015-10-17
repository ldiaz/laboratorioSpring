package com.laboratorioprueba.laboratorio1.spring_mvc.rest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.laboratorioprueba.laboratorio1.spring_mvc.controladores.api.ControladorApiEstudiante;
import com.laboratorioprueba.laboratorio1.spring_mvc.domain.Estudiante;
import com.laboratorioprueba.laboratorio1.spring_mvc.servicios.ServicioEstudiante;



import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import static org.mockito.


@RunWith(MockitoJUnitRunner.class)
public class ControladorApiEstudianteTest {
	
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
 
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
     }
	
	@InjectMocks
	  private ControladorApiEstudiante controller;
	  @Mock
	  private ServicioEstudiante servicio;
	  
	  private static final  Estudiante e1 = new Estudiante(1, "Diego", "Camayo", "CC");
	  private static final  Estudiante e2 = new Estudiante(2, "Leonardo", "Diaz", "CC");
	  
	  @Test
	  public void whenFindingItemsItShouldReturnAllItems() {
	    // Given that the repository returns CHECKED_ITEM and UNCHECKED_ITEM
//	    given(servicio.listarEstudiantes(1, 2)).willReturn(Arrays.asList(e1, e2));
		  Mockito.when(servicio.listarEstudiantes(1,5)).thenReturn(Arrays.asList(e1, e2));
	    // When looking for all items
		  
	    assertThat(controller.listarEstudiantes())
	    // Then it should return the CHECKED_ITEM and UNCHECKED_ITEM 
	    .containsOnly(e1, e2);
	  }
 
 
	  @Test
    public void findAll_students_with_controller() throws Exception {
		  Mockito.when(servicio.listarEstudiantes(1,5)).thenReturn(Arrays.asList(e1, e2));

		  mockMvc.perform(get("/api/estudiantes"))
        .andExpect(status().isOk());
    }
	  
//    @Test
//    public void findAll_ShouldAddTodoEntriesToModelAndRenderTodoListView() throws Exception {
////        Todo first = new TodoBuilder()
////                .id(1L)
////                .description("Lorem ipsum")
////                .title("Foo")
////                .build();
//        Estudiante e1 = new Estudiante(1, "Diego", "Camayo", "CC");
//        Estudiante e2 = new Estudiante(2, "Leonardo", "Diaz", "CC");
// 
//        
// 
//        //when(estudianteServiceMock.listarEstudiantes(1, 5)).thenReturn(Arrays.asList(e1, e2));
// 
//        mockMvc.perform(get("/estudiantes"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("todo/list"))
//                .andExpect(forwardedUrl("/WEB-INF/jsp/todo/list.jsp"))
//                .andExpect(model().attribute("todos", hasSize(2)))
//                .andExpect(model().attribute("todos", hasItem(
//                        allOf(
//                                hasProperty("id", is(1L)),
//                                hasProperty("description", is("Lorem ipsum")),
//                                hasProperty("title", is("Foo"))
//                        )
//                )))
//                .andExpect(model().attribute("todos", hasItem(
//                        allOf(
//                                hasProperty("id", is(2L)),
//                                hasProperty("description", is("Lorem ipsum")),
//                                hasProperty("title", is("Bar"))
//                        )
//                )));
// 
//        verify(estudianteServiceMock, times(1)).listarEstudiantes(1, 5);
//        verifyNoMoreInteractions(estudianteServiceMock);
//    }
	 
}