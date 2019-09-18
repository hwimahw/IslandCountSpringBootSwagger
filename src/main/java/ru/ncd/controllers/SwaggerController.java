package ru.ncd.controllers;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ncd.*;
import ru.ncd.objectInitializers.GraphInitializer;
import ru.ncd.objectInitializers.MatrixInitializer;
import ru.ncd.objects.Graph;
import ru.ncd.objects.Matrix;

import java.io.InputStream;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/api/v1/file")
@Api(value = "/api/v1/file")
public class SwaggerController {

    final Data data;
    final DataDAO dataDAO;
    final FileInputStream fileInputStream;
    final Matrix matrix;
    final Graph graph;
    final MatrixInitializer mi;
    final GraphInitializer gi;
    final DataInitializer di;

    public SwaggerController(Data data, DataDAO dataDAO, FileInputStream fileInputStream, Matrix matrix, Graph graph, MatrixInitializer mi, GraphInitializer gi, DataInitializer di) {
        this.data = data;
        this.dataDAO = dataDAO;
        this.fileInputStream = fileInputStream;
        this.matrix = matrix;
        this.graph = graph;
        this.mi = mi;
        this.gi = gi;
        this.di = di;
        System.out.println(11111111);
    }


    //   @Autowired
 //   Graph graph;

 //   @Autowired
 //   MatrixInitializer mi;

 //   @Autowired
 //   GraphInitializer gi;

 //   @Autowired
 //   DataInitializer di;


   /* @Autowired
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
    }*/

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public Data postFile(
    @ApiParam(name = "file", value = "Файл", required = true)
    @RequestParam(name = "file") MultipartFile file) throws Exception  {
        InputStream fileStream = file.getInputStream();
        InputStream fileStreamNew = file.getInputStream();

        CheckFileCorrectness checkFileCorrectness = new CheckFileCorrectness();
        checkFileCorrectness.check(fileStream);

        mi.matrixInitialize(fileStreamNew, matrix);

        gi.graphInitialize(graph, matrix);

        di.dataInitialize(data, matrix, graph);

        return dataDAO.addToDataBase(data, matrix, graph);
    }
}

