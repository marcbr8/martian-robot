package org.marcbr8.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.marcbr8.model.Coordinates;
import org.marcbr8.model.MarsGrid;
import org.marcbr8.service.MarsGridService;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.assertj.core.util.Sets.newHashSet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MarsGridControllerTest {

    @Mock
    private MarsGridService marsGridService;

    private MockMvc mockMvc;


    @Test
    public void shouldReturnPostedGrid() throws Exception {
        final MarsGrid grid = new MarsGrid(Coordinates.of(2,3));
        when(marsGridService.storeMarsGrid(eq(grid))).thenReturn(grid);
        final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String gridAsString = objectWriter.writeValueAsString(grid);
        mockMvc.perform(MockMvcRequestBuilders.post("/grid/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gridAsString))
                .andExpect(status().isOk())
                .andExpect(content().json(gridAsString));
        verify(marsGridService).storeMarsGrid(eq(grid));
    }

    @Test
    public void shouldReturnStoredGrids() throws Exception {
        final MarsGrid grid1 = new MarsGrid(Coordinates.of(2,3));
        final MarsGrid grid2 = new MarsGrid(Coordinates.of(4,3));
        final HashSet<MarsGrid> grids = newHashSet();
        grids.add(grid1);
        grids.add(grid2);
        when(marsGridService.getStoredMarsGrids()).thenReturn(grids);
        final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String gridsAsString = objectWriter.writeValueAsString(grids);
        mockMvc.perform(MockMvcRequestBuilders.get("/grid/"))
                .andExpect(status().isOk())
                .andExpect(content().json(gridsAsString));
        verify(marsGridService).getStoredMarsGrids();
    }

    @Test
    public void shouldClearGridsOnDemand() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.delete("/grid/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
        verify(marsGridService).clearGrids();
    }

    @BeforeEach
    public void setup(){
        setupMockMvc();
    }

    private void setupMockMvc() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new MarsGridController(marsGridService))
                .build();
    }

}