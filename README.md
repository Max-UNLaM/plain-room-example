# Robot Room Showcase 馃

Este es un proyecto peque帽o con el objeto de mostrar c贸mo funciona la librer铆a ROOM. Para restarle
complejidad, se realiza sin inyecci贸n autom谩tica de dependencias ni respetando el patr贸n
repositorio. Un proyecto con esas caracter铆sticas se ver谩 en otro repositorio.

## Pasos para replicar el comportamiento del proyecto

### 1 A帽adir dependendencias:

 ```gradle
 
apply plugin: "kotlin-kapt"
 
dependencies {
    def room_version = "2.3.0"
    
    // Other dependencies
    
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"

 ```

### 2 Habilitar View Binding:

```gradle
android {
    // Otras configuraciones
    viewBinding {
        enabled = true
    }
}
```

## Consideraciones t茅cnicas

Se han realizado algunos workarounds para poder consumir Room sin elevar el grado de complejidad
visto hasta ahora. En pr贸ximos proyectos veremos como resolver estas cuestiones de forma m谩s
eficiente.

### Inyecci贸n Manual

El Main Activity est谩 construyendo sus dependencias manualmente durante su propia construcci贸n. Esto
ser谩 reemplazado por una m谩s apropiada Inyecci贸n en un proyecto posterior.

### Queries en thread principal

Se est谩 construyendo a la base de datos usando allowMainThreadQueries(). Esto permite realizar
ejecuciones sincr贸nicas en el hilo principal del proyecto. Id贸neamente, esto no debiera de ser
llamado y las queries debieran de ser realizadas asincr贸nicamente para no bloquear la ejecuci贸n del
programa. Veremos este comportamiento en un proyecto posterior.