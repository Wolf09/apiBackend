package com.example.apibackend.model.services;


import org.example.apijar.model.dto.*;
import com.example.apibackend.model.dao.Bitacora;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDateTime;
import java.util.*;

public class Datos {

    /* DATOS PARA HEROES */
    private static List<Item> misItems= Arrays.asList(new Item("http://imagenes","imagenes","imagenes"));

    private static ArrayList<Item> items= new ArrayList<>(misItems);

    private static List<Url> misUrls= Arrays.asList(new Url("url","http://imagenes"));

    private static ArrayList<Url> urls= new ArrayList<>(misUrls);

    // LISTA DE HEROES
    public static final List<Heroe> HEROES= Arrays.asList(
            new Heroe(11111,"Hulk","Hulk (también llamado El Hombre Increíble), es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics",
            new Date(),new Thumbnail("images/hulk","jpg"),"/images/hulk",new Comics(1,"imagenes",items,1),
            new Series(1,"imagenes",items,1),new Stories(1,"imagenes",items,1),
            new Events(1,"imagenes",items,1), urls),
            new Heroe(22222,"Capitán América","El Capitán América, cuyo nombre real es Steven Grant Rogers, es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics.",
            new Date(),new Thumbnail("images/capitan","jpg"),"/images/capitan",new Comics(1,"imagenes",items,1),
            new Series(1,"imagenes",items,1),new Stories(1,"imagenes",items,1),
            new Events(1,"imagenes",items,1), urls),
            new Heroe(33333,"Iro Man","Iron Man (conocido en español como el Hombre de Hierro) es un superhéroe que aparece en los cómics estadounidenses publicados por Marvel Comics",
            new Date(),new Thumbnail("images/ironman","jpg"),"/images/ironman",new Comics(1,"imagenes",items,1),
            new Series(1,"imagenes",items,1),new Stories(1,"imagenes",items,1),
            new Events(1,"imagenes",items,1), urls),
            new Heroe(44444,"Wonder Woman","La Mujer Maravilla (en inglés: Wonder Woman). Es una princesa guerrera de las Amazonas, pueblo ficticio basado en el de las amazonas de la mitología griega.",
            new Date(),new Thumbnail("images/wonderwoman","jpg"),"/images/wonderwoman",new Comics(1,"imagenes",items,1),
            new Series(1,"imagenes",items,1),new Stories(1,"imagenes",items,1),
            new Events(1,"imagenes",items,1), urls),
            new Heroe(55555,"Aquaman","Aquaman (Arthur Curry) (en español: Hombre Acuático) es un superhéroe que aparece en los cómics estadounidenses publicados por DC Comics.",
            new Date(),new Thumbnail("images/aquaman","jpg"),"/images/aquaman",new Comics(1,"imagenes",items,1),
            new Series(1,"imagenes",items,1),new Stories(1,"imagenes",items,1),
            new Events(1,"imagenes",items,1), urls));

    // LISTA DE BITACORAS
    public static final List<Bitacora> BITACORAS= Arrays.asList(new Bitacora(1L,"3F-4H-6G-7L","todosLosHeroes()", LocalDateTime.now()),
                                        new Bitacora(2L,"3F-4H-6G-7L","heroePorId()", LocalDateTime.now()),
                                        new Bitacora(3L,"3F-4H-6G-7L","heroePorId()", LocalDateTime.now()),
                                        new Bitacora(4L,"3F-4H-6G-7L","todosLosHeroes()", LocalDateTime.now()));
    //NUEVA BITACORA
    public static final Bitacora BITACORA= new Bitacora(null,"3F-4H-6G-7L","heroePorId()",LocalDateTime.now());

    // BUSCAR HEROE POR ID
    public static Heroe buscarHero(int id){
        Heroe myHero=null;
        Optional<Heroe> result =HEROES.stream().filter(heroe -> heroe.getId()==id).findFirst();
        if (result.isPresent()){
           myHero = result.get();
        }
        return myHero;
    }






}
