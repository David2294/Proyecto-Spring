



CREATE TABLE `Categorias` (
  `id_categorias` int NOT NULL AUTO_INCREMENT,
  `nombre_categorias` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categorias`)
) ENGINE=InnoDB CHARSET=utf8mb4  ;

INSERT INTO `Categorias` VALUES (1,'lacteo'),(2,'carnicos'),(3,'pescado');



CREATE TABLE `productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `id_categoria` int NOT NULL,
  `nombre_producto` varchar(100) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categorias`)
) ENGINE=InnoDB CHARSET=utf8mb4  ;

INSERT INTO `productos` VALUES (1,1,'leche entera'),(4,3,'margarita'),(8,1,'perro'),(9,2,'gaseosa');

CREATE TABLE `carrito_compras` (
  `id_carrito` int NOT NULL AUTO_INCREMENT,
  `id_producto` int NOT NULL,
  `detalle` varchar(100) CHARACTER SET utf8mb4  DEFAULT NULL,
  `costo_und` float NOT NULL,
  `costo_total` float NOT NULL,
  `metodo_pago` varchar(100) NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id_carrito`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `carrito_compras_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB CHARSET=utf8mb4  ;

INSERT INTO `carrito_compras` VALUES (4,4,'para_comer',200,400,'efectivo',2),(5,1,'para_comer',200,600,'efectivo',3),(6,1,'para_comer',200,600,'efectivo',3),(7,1,'para_comer',200,600,'efectivo',3),(8,1,'para_comer',200,600,'efectivo',3),(9,1,'para_comer',200,600,'efectivo',3);
