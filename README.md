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