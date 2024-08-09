package com.Butterfly.services;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "butterfly-26075.appspot.com";

    //Esta es la ruta básica de este proyecto butterfly
    final String rutaSuperiorStorage = "Butterfly";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";

    //El nombre del archivo Json
    final String archivoJsonFile = "butterfly-26075-firebase-adminsdk-4lkbj-0dc739abaf";
}

