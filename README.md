# Bank Manager
Exposicion de una combinacion de servicios web REST y SOAP para las administracion de bancos, sucursales y ordenes de pago

## Entidades
- Banco
- Sucursal
- Order de Pago

## Servicios
- Para el consumo de los servicios usar el prefijo *http://servername:port/bankservice* seguido de los endpoint que se documentan a continuacion
> REST

#### Servicios para el mantenimiento de todas las entidades

##### Banco
- /bank - Obtener todos los bancos
- /bank/{id} - Obtener un banco segun su id
- /bank/save - Registrar un banco

##### Sucursal
- /branch - Obtener todas las sucursales
- /branch/{id} - Obtener una sucursal segun su id
- /branch/save/{id} - Registrar una sucursal a un banco, dado el id del banco

##### Orden de pago
- /payment - Obtener todas las ordenes
- /payment/{id} - Obtener una orden segun su id
- /payment/save - Registrar una orden

#### Listar las ordenes de pago de una sucursal segun el tipo de moneda
- /branch/payments/{id}

> SOAP
#### Listar las sucursales de un banco
- /sucursalesservice - Obtener todas las sucursales de un banco dado el nombre del banco

## Ejemplos de objetos válidos para peticiones
> Banco
```json
{
    "name":"Bank",
    "address":"Your address",
    "registrydate":"12/12/21"
}
```
> Sucursal
```json
{
    "name":"Sucursal",
    "address":"Your address",
    "registrydate":"12/12/21"
}
```
> Orden de pago
```json
{
    "amount":100,
    "currency":"Euro",
    "state":2,
    "paymentDate":"12/12/21"
}
"state" es un enumerado que representa el estado de la orden, sus posibles valores son:
- 1 (PAYED)
- 2 (DECLINED)
- 3 (FAILED)
- 4 (CANCELED)
```

## Descargar proyecto
```
$ git clone https://github.com/dperezh/-bankManager.git
```

## Install
```
$ mvn clean install
```

## Iniciar
```
$ mvn spring-boot:run
```
