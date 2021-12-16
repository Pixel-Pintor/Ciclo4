package com.c4reto4;

import com.c4reto4.repository.crud.OrderCrudRepository;
import com.c4reto4.repository.crud.PeripheralCrudRepository;
import com.c4reto4.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto4Application implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userRepo;

    @Autowired
    private PeripheralCrudRepository supRepo;

    @Autowired
    private OrderCrudRepository orderRepo;

    public static void main(String[] args) {
        SpringApplication.run(Reto4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        supRepo.deleteAll();
        orderRepo.deleteAll();

        //para efectos de formateo de fechas
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//        userRepo.saveAll(
//                List.of(
//                        new User(1, "123123", "ALAN BRITO", ft.parse("1986-11-15"), "11", "CR 34-45", "311222222", "abrito@gmail.com", "Demo123.", "ZONA 2", "ADM"),
//                        new User(2, "61123211", "NAPOLEON BONAPARTE", ft.parse("1966-11-15"), "11", "CR 34-45", "3168965645", "nbonaparte@gmail.com", "Demo123.", "ZONA 2", "COORD"),
//                        new User(3, "46669989", "BLODY MARRY", ft.parse("1996-11-15"), "11", "CR 34-45", "3174565625", "stellez@gmail.com", "Demo123.", "ZONA 2", "ASE"),
//                        new User(4, "52369563", "JUANA DE ARCO", ft.parse("1987-05-15"), "05", "CR 34-45", "3265632", "jdarco@gmail.com", "Demo123.", "ZONA 2", "ASE"),
//                        new User(5, "123456789", "ALCIRA LA ALPACA", ft.parse("1966-02-15"), "02", "CR 34-45", "3168965645", "aalpaca@gmail.com", "Demo123.", "ZONA 1", "COORD"),
//                        new User(6, "213456789", "PEDRO CAPAROSA", ft.parse("1966-02-15"), "02", "CR 34-45", "3168965645", "pcaparosa@gmail.com", "Demo123.", "ZONA 1", "ASE"),
//                        new User(7, "312456789", "LUIS IXV UN SOL", ft.parse("1966-02-15"), "02", "CR 34-45", "3168965645", "reysol@gmail.com", "Demo123.", "ZONA 1", "ASE")
//                )
//        );
//
//        supRepo.saveAll(
//                List.of(
//                        new Supplement("AP-903", "MARCA 1", "CATEGORIA 1", "OBJETIVO 1", "Descripción: ALTA CALIDAD, BAJO PRECIO", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg"),
//                        new Supplement("AP-904", "MARCA 2", "CATEGORIA 2", "OBJETIVO 1", "Descripción: CALIDAD, ECOMIA, PRE ENTRENO", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-007.jpg"),
//                        new Supplement("AP-905", "MARCA 3", "CATEGORIA 3", "OBJETIVO 1", "Descripción: AUMENTO DE MASA MUSCULAR", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg"),
//                        new Supplement("AP-906", "MARCA 4", "CATEGORIA 4", "OBJETIVO 1", "Descripción: POTEINA LIMPIA DE LA TA CALIDAD", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-007.jpg"),
//                        new Supplement("AP-907", "MARCA 5", "CATEGORIA 5", "OBJETIVO 1", "Descripción: CALIDAD", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg"),
//                        new Supplement("AP-908", "MARCA 6", "CATEGORIA 6", "OBJETIVO 1", "Descripción: PRECIO JUSTO", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-007.jpg"),
//                        new Supplement("AP-909", "MARCA 7", "CATEGORIA 7", "OBJETIVO 1", "Descripción: CALIDAD", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-006127.jpg"),
//                        new Supplement("AP-910", "MARCA 8", "CATEGORIA 8", "OBJETIVO 1", "Descripción: CALIDAD", true, 150000, 10, "https://www.avasoluciones.com/uploads/2021/09/910-007.jpg")
//                )
//        );


//        //Instanciar las ordenes
//        Order orderOne = new Order();
//        orderOne.setId(1);
//        Order orderTwo = new Order();
//        orderTwo.setId(2);
//        Order orderTree = new Order();
//        orderTree.setId(3);
//
//        //Recuperar vendedores
//        Optional<User> salesManOne = userRepo.findById(3);
//        Optional<User> salesManTwo = userRepo.findById(6);
//
//        //Mapa de productos asociados a una orden
//        Map<String, Supplement> productOrderOne = new HashMap<String, Supplement>();
//        Map<String, Supplement> productOrderTwo = new HashMap<String, Supplement>();
//        Map<String, Supplement> productOrderTree = new HashMap<String, Supplement>();
//
//        //Mapa de cantidades de producto asociados a una orden
//        Map<String, Integer> quantitiesOrderOne = new HashMap<String, Integer>();
//        Map<String, Integer> quantitiesOrderTwo = new HashMap<String, Integer>();
//        Map<String, Integer> quantitiesOrderTree = new HashMap<String, Integer>();
//
//        //lista de producto de la orden 1
//        productOrderOne.put("AP-903", supRepo.findById("AP-903").get());
//        productOrderOne.put("AP-904", supRepo.findById("AP-904").get());
//
//        //Cantidades de producto de la orden 1
//        quantitiesOrderOne.put("AP-903", 1);
//        quantitiesOrderOne.put("AP-904", 1);
//
//        //lista de producto de la orden 2
//        productOrderTwo.put("AP-903", supRepo.findById("AP-903").get());
//        productOrderTwo.put("AP-904", supRepo.findById("AP-904").get());
//
//        //Cantidades de producto de la orden 2
//        quantitiesOrderTwo.put("AP-903", 1);
//        quantitiesOrderTwo.put("AP-904", 1);
//
//
//
//        //lista de producto de la orden 3
//        productOrderTree.put("AP-904", supRepo.findById("AP-904").get());
//
//        //Cantidades de producto de la orden 3
//        quantitiesOrderOne.put("AP-904", 10);
//
//        //Configuraciòn datos orden 1
//        orderOne.setRegisterDay(ft.parse("2021-09-15"));
//        orderOne.setStatus(Order.PENDING);
//        orderOne.setSalesMan(salesManOne.get());
//        orderOne.setProducts(productOrderOne);
//        orderOne.setQuantities(quantitiesOrderOne);
//
//        //Configuraciòn datos orden 2
//        orderTwo.setRegisterDay(ft.parse("2021-09-15"));
//        orderTwo.setStatus(Order.PENDING);
//        orderTwo.setSalesMan(salesManTwo.get());
//        orderTwo.setProducts(productOrderTwo);
//        orderTwo.setQuantities(quantitiesOrderTwo);
//
//        //Configuraciòn datos orden 3
//        orderTree.setRegisterDay(ft.parse("2021-06-12"));
//        orderTree.setStatus(Order.PENDING);
//        orderTree.setSalesMan(salesManTwo.get());
//        orderTree.setProducts(productOrderTree);
//        orderTree.setQuantities(quantitiesOrderTree);
//
//
//        //registra las ordenes en la base de datos
//        //imprime el los datos de las ordenes
//        orderRepo.saveAll(List.of(orderOne, orderTwo, orderTree));
//
//        System.out.println("Listado de ordenes");
//        orderRepo.findAll().forEach(System.out::println);
    }

}
