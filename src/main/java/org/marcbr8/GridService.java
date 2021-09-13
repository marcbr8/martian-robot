package org.marcbr8;

import org.marcbr8.model.Coordinates;
import org.marcbr8.model.MarsGrid;
import org.springframework.stereotype.Service;

@Service
public class GridService {

    public MarsGrid getGridWithId(final Integer id){
        return new MarsGrid( new Coordinates(5,2));
    }

}
