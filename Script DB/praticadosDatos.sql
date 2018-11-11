INSERT INTO `practicados`.`rol` (`idrol`, `rol`) VALUES('1', 'gerente'),('2', 'vendedor'),('3', 'contador');
INSERT INTO `practicados`.`users` (`idusers`, `username`, `password`, `idrol`) VALUES ('1', 'gerente', 'Z2VyZW50ZQ==', '1'),('2', 'vendedor', 'dmVuZGVkb3I=', '2'),('3', 'contador', 'Y29udGFkb3I=', '3');
NSERT INTO `practicados`.`equipment` (`idequipment`, `brand`, `status`, `dateBuy`, `name`, `description`) VALUES ('2', 'Asus', 'En buen estado', '2018-11-11', 'Equipo de admon', 'Intel Core I7, 8GB RAM');
NSERT INTO `practicados`.`products` (`idproducts`, `name`, `brand`, `dateBuy`, `cost`, `price`, `description`, `uso`) VALUES ('1', 'Leche', 'Colanta', '2018-11-01', '1000', '2000', 'Leche entera de bolsa', '0');
