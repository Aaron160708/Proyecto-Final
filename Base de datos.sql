CREATE DATABASE IF NOT EXISTS sistema_ventas;

USE sistema_ventas;

CREATE TABLE IF NOT EXISTS producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    precio DECIMAL(10,2),
    stock INT,
    activo TINYINT(1) NOT NULL DEFAULT 1 
);

CREATE TABLE IF NOT EXISTS venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS venta_detalle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT,
    producto_id INT,
    cantidad INT,
    subtotal DECIMAL(10,2),
    FOREIGN KEY (venta_id) REFERENCES venta(id),
    FOREIGN KEY (producto_id) REFERENCES producto(id)
);

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100) UNIQUE,
    contrasena VARCHAR(100)
);