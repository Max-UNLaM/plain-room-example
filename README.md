# Robot Room Showcase 🦾

Este es un proyecto pequeño con el objeto de mostrar cómo funciona la librería ROOM. Para restarle
complejidad, se realiza sin inyección automática de dependencias ni respetando el patrón
repositorio. Un proyecto con esas características se verá en otro repositorio.

## Pasos para replicar el comportamiento del proyecto

### 1 Añadir dependendencias:

 ```gradle
 
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

## Consideraciones técnicas

Se han realizado algunos workarounds para poder consumir Room sin elevar el grado de complejidad
visto hasta ahora. En próximos proyectos veremos como resolver estas cuestiones de forma más
eficiente.

### Inyección Manual

El Main Activity está construyendo sus dependencias manualmente durante su propia construcción. Esto
será reemplazado por una más apropiada Inyección en un proyecto posterior.

### Queries en thread principal

Se está construyendo a la base de datos usando allowMainThreadQueries(). Esto permite realizar
ejecuciones sincrónicas en el hilo principal del proyecto. Idóneamente, esto no debiera de ser
llamado y las queries debieran de ser realizadas asincrónicamente para no bloquear la ejecución del
programa. Veremos este comportamiento en un proyecto posterior.