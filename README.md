# Facturas
LA COMPU S.A., una empresa minorista de cómputo, desea manejar sus facturas mediante un sistema de información.

Actualmente, las facturas (Fig. 1) se solicitan a la imprenta, quien las entrega con un número de factura impreso en un rango definido, por ejemplo, de la A2300 a la A3500. El RUT representa el Registro Único Tributario o RFC (Registro Federal de Contribuyente). El dato referente a Cons. Final, aunque sigue apareciendo en la factura, no es utilizado. Cuando un cliente adquiere por ejemplo uno o más artículos, se llena a mano la factura al momento de pagar.


## Fig. 1. Ejemplo de Factura sin datos

<p align="center">
    <img src="https://github.com/ElJeroGGs/Facturas/assets/148837954/a01e10f1-1455-4dd2-bb23-653c9a940a31" />
</p>

Como primera etapa y como parte del sistema de información, se modelará, diseñará e implementará la base de datos, misma que permitirá a la empresa realizar las siguientes actividades mediante programas o scripts.

- [x] Crear la base de datos incluyendo restricciones de llaves y columnas, de acuerdo con el diseño obtenido
- [x] Registrar clientes. Convertir automáticamente en mayúsculas los datos de tipo cadena ingresados
- [x] Modificar, eliminar y consultar clientes
- [x] Registrar productos. Convertir automáticamente en mayúsculas los datos de tipo cadena ingresados
- [x] Modificar, eliminar y consultar productos o artículos
- [x] Crear un listado de todos los clientes
- [x] Crear un listado de todos los artículos o productos
- [x] Registrar facturas con sus ventas correspondientes. Para evitar errores de cálculo, cada que se haga una venta, se deberá calcular automáticamente y actualizar en las tablas correspondientes el monto total de la venta, el subtotal, iva y gran total de la factura 
- [x] Recupera los datos de facturas de forma individual (incluye los datos de la factura, cliente, productos y ventas) 
- [x] Consulta de cantidad de productos o artículos vendidos a través de una factura determinada¨
- [x] Generación de facturas "listas" para impresión con base en el formato siguiente

    LA COMPU  
    Factura:   [ A2345 ]  
    Fecha:     [ 17/11/2023 ]  
    RUT:       [ ABCD123456789 ]  
    Nombre:    [ DOROTEO ABIMAEL CONTRERAS ]  
    Domicilio: [ MORELOS 301. TOLUCA, CENTRO ]  
    Teléfono:  [ 7225987456 ]  

    ----------------------------------------------------------

    | Código | Descripción        | Cant | Precio U. | Total   |
    |--------|--------------------|------|-----------|---------|
    | A2317  | TECLADO MECÁNICO   | 2    | 3,800.50  | 7,601.00|
    | M5778  | DIADEMA GAMER      | 1    | 3,200.00  | 3,200.00|
    | R7329  | TAPETE PARA MOUSE  | 1    | 450.99    | 450.99  |

    ----------------------------------------------------------

    Subtotal: 11,251.99  
    IVA: 1,687.80  
    Total: $12,939.79  
                                         
- [x] Aplicación cliente-servidor (Java-Oracle) que incluya el CRUD para al menos una tabla, y la generación de la factura 

## El modelo lógico a utilizar es el siguiente
<p align="center">
    <img src="https://github.com/ElJeroGGs/Facturas/assets/148837954/03293b0b-e411-4f38-a655-28292c1d6e19" />
</p>



III. Con base en los puntos anteriores, elabora los modelos lógico, relacional y físico de la base de datos y construye los programas o scripts que incluyan DDL, DML, transacciones y objetos para crear y manejar la base datos. Para cada una de los scripts, indica que actividad o necesidad apoya.

### El proyecto se entrego sin la pestaña de factura funcionando al 100%, sin embargo, me sabía mal dejarlo a medias, así que terminé de pulir y hacer la pestaña de facturas - Jero
