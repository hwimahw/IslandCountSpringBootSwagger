package ru.ncd;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/api/v1/file")
@Api(value = "/api/v1/file")
public class SwaggerController {

    Data data;
    DataDAO dataDAO;
    FileInputStream fileInputStream;
    Matrix matrix;
    Graph graph;
    MatrixInitializer mi;
    GraphInitializer gi;
    DataInitializer di;

 //   @Autowired
 //   Graph graph;

 //   @Autowired
 //   MatrixInitializer mi;

 //   @Autowired
 //   GraphInitializer gi;

 //   @Autowired
 //   DataInitializer di;


    @Autowired
    public void setDataDAO(DataDAO dataDAO){
        this.dataDAO = dataDAO;
    }
    @Autowired
    public void setFileInputStream(FileInputStream fileInputStream){
        this.fileInputStream = fileInputStream;
    }
    @Autowired
    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
    @Autowired
    public void setData(Data data) {
        this.data = data;
    }
    @Autowired
    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    @Autowired
    public void setGi(GraphInitializer gi) {
        this.gi = gi;
    }
    @Autowired
    public void setMi(MatrixInitializer mi) {
        this.mi = mi;
    }
    @Autowired
    public void setDi(DataInitializer di) {
        this.di = di;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public Data postFile(
    @ApiParam(name = "file", value = "Файл", required = true)
    @RequestParam(name = "file") MultipartFile file) throws IOException{
        InputStream fileStream = file.getInputStream();
        mi.matrixInitialize(fileStream, matrix);

        gi.graphInitialize(graph, matrix);

        di.dataInitialize(data, matrix, graph);

        return dataDAO.addToDataBase(data, matrix, graph);
    }
}

