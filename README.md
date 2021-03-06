# MarvelTest

En este proyecto se ha elaborado la aplicación sobre los personajes de Marvel solicitada.

## Introducción

Para el desarrollo de este proyecto y su posible compilado, se ha estableceido su desarrollo con Kotlin, JAVA 11 y Android Studio Arctic Fox. Se ha eliminado jcenter dado que ya está deprecado.

## Arquitectura

Para la arquitectura se ha utilizado la recomendado por Google, MVVM, pero con alguna variante para hacerla más completa. Realmente es un MVVMI (model, view, view-model, interactor).

- View: se han utilizado Activity, Fragment y Adapters. Tienen una instancia de su presenter asoaciado, para interactuar con él y pedir los datos y/o lógica necesaria. Lo hace a través del patrón Observable de los LiveData. Las vistas se comunican siempre por una interfaz de los presentadores.
- View Model: el nombrado es de "Presenter", para conciliar los nombres a arquitecturas predecesoras a ellas (MVP). Estos presentadores extienden de ViewModel para que su ciclo de vida estñe ligado al de las vistas. Trabajo con LiveData para comunicarse con las vistas y tiene a su vez interfaces de los interactors (casos de uso) para pedir datos y/o desarrollar lógica de negocio. 
- Use Case (Interactors): esta capa es una capa intermedia que comunica al presentador con el modelo. Su función es realizar lógica de negocio, realización y unificación de datos de diferentes modelos, etc. Esta clase tiene las interfaces de las clases modelos convenientes.
- Model: capa que recupera los datos de diferentes fuentes (servidor, preferencias, base de datos, etc). En este caso, solo tenemos un origen de datos. Se llaman Repository.

Las capas nunca se comunican entre si directamente, sino con interfaces que eviten acoplamiento. Del presentador hacia la vista la comunicación es via Observable gracias a los LiveData y la comunicación entre el resto de capas se hace vía Corrutinas. 

Se ha utilizado Retrofit y OkHttp para las conexiones con la API.

Se ha establecido dos modelos con lo que trabaja el proyecto: DTO (Data Transfer Object) y BO (Business Object). Los modelos DTO representan los modelos de datos tal cuál llegan de los diferentes orígenes que pueden existir. Esos DTO tienen todos los datos que devuelve esos orígenes. Los casos de usos serán los encargados de "mapear" esos modelso DTO a modelos BO, con la información estrictamente necesaria para el desarrollo de lógicas y vistas, con el fin de simplificar los modelos a las capas finales. Se ha decidido no introducir los VO (Value Object) dado que para este proyecto (y generalmente aquellos que solo tratan de mostrar datos) añade más complejidad que beneficio del mismo: habría que mantener 3 modelos de datos diferentes. Una arquitectura debe beneficiar al proyecto y no cargarla innecesariamente. En esta prueba simplemente se han añadido algunas cosas más para demostrar diferentes opciones.

Se ha utilizado Koin como DI (Dependency Injection).

Se han añadido entornos de compilación (pre y pro) y versiones de firmado diferentes (debug y release). A la versión de release se aplicará proguard y ofuscará el código. No es debuggable en este tipo de compilados. 

Se han establecido variables de configuración en el gradle para mayor seguridad, que no estén en el código como constantes.

## Base

Se ha establecido un paquete "base" con clases base para el proyecto:

- BaseActivity: esta clase heredarán todas las activities del proyecto. Con el se quiere conseguir un "autotrackeo" de vistas a Firebase Analytics, sin tener cada Activity y su Presentador tener que hacerlo. Basta con darle un contenido al mñetodo abstracto del BaseActivity para trackear automaticamente lo que se quiera. También tiene dos métodos para que todas las activities lo implementen: cargar observadores hacia el presenter y eliminar observadores. De hecho, el onDestroy del base se encargará de eliminar los observadores que tenga esa activity para que no existan problemas de comunicación.
- AnalyticsPresenter: presenter de analíticas que se encarga de enviar los datos al caso de uso de analíticas. Sirve tanto para BaseActivity trackear todas las pantallas, como para todas las activities que quieran usarla para trackear eventos concretos.
- BaseFragment. El mismo caso que el BaseActivity pero para Fragments.

## Seguridad

Se ha añadido proguard para las compilaciones en modo Release para la oguscación de código. 

## Retrofit

Indicar que los modelos llevan la etiqueta @SerializedName dado que he utilizado un plugin que autogenera los modelos. Si los nombres de las data classes DTO tienen el mismo que el json, se puede omitir este etiquetado. Solo tiene la ventaja cuando quieres ponerles diferentes nombres.

Se ha puesto todo como opcional "?" dado que en la API se establece que prácticamente todo puede ser opcional.

## Firebase

Se ha añadido Firebase a través de Firebase BoM, para un correcto versionado de las librerías. Se ha añadido Crashlytics y Analíticas.

Tiene un fichero google.json diferente para cada entorno ya que son dos proyectos diferentes en Firebase: uno para PRE para su propio empaquetado y otro para PRO.

## Comunicación con Corrutinas y gestión de errores

Para la comunicación de Corrutinas y gestión errores se han usado dos clases: ResultHandler<T> y AppResultHandler<T>. Dado que las corrutinas solo devuelven un tipo de datos, se ha creado esas dos clases para poder devolver diferentes tipos. ResultHandler se utiliza para la gestión de success y error entre la capa de Model e Interactor. Para el resto se usa AppResultHandler que tiene menos casos.
  
Se ha realizado una gestión genérica del tratamiento de errores al a hora de recibir una respuesta de servidor (mirar BaseApi). 

## Carga de imágenes
  
Se ha utilizado Glide para la carga de imágenes. Se ha tenido que añadir al Manifest android:usesCleartextTraffic="true" dado que las urls de imñagenes dee Marvel son por http y no por https, por lo que se ha tenido que añadir si no no cargan imágenes.
  
Para mayor facilidad, dado que la prueba ha sido larga, se ha utilizado xlarge para las imñagenes de la API de Marvel como parámetro de la url.
  
## Paginación
  
Dado que el primer servicio es paginado, se ha implementado un recyclerview con paginación, cargando datos de 20 en 20 al llegar al final del scroll.
  
## Recursos
  
Se ha implementado traducciones (inglés - español). Por defecto, será en inglés.
  
Se ha implementado estilos, animaciones, dimens y colores.
  
## Accesibilidad
  
Se ha etiquetado todos los ImageView con contentDescription="@null" para que el Talkback de Android no lo reconozca directamente. Si se quisiera que dijese algo al pasar el dedo y lo reconozca, solo habría que establecer un texto.
  

