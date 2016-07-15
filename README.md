# hb-geoxml
GeoXML XSD with scalaxb procedure to generate XML data-binding for Scala
* [[http://scalaxb.org/

# Usage
*`sbt` command can be replaced by `activator` `act` or whatever your aliases and sbt build tool is named. From now on `sbt` is used.*

## Code Generation 
    sbt compile 

This will generate three .scala source files:

    geoXml.scala
    geoXmlProtocol.scala
    scalaxb.scala

### Model 
`geoXml.scala` file contains model traits, classes and objects that are used everywhere the corresponding geoXml.xsd schema elements are used in Scala

### Protocol
`geoXmlProtocol.scala` file formats scala.xml objects to geoXml defined model using scalaxb.XMLFormat 

### Scalaxb Package
`scalaxb` package provides functions to read and write from scala.xml to Scala types as for instance toXML[A] where A can be any model class or object such as MELFIN, ELFIN, POINT...

# IDE integration

## Eclipse

    sbt eclipse 

## Intellij IDEA

Check https://github.com/mpeltonen/sbt-idea 



