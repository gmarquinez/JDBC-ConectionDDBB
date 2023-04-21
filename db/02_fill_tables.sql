
INSERT INTO biblioteca (nombre) VALUES
("Biblioteca Aragon"),
('Biblioteca Avenidas'),
("Biblioteca Plaza Madrid");



INSERT INTO libros (id_biblioteca, isbn, titulo, autor, editorial, numcopias, numcopiasdisponibles) VALUES
(1,"12345", "Cien años de soledad", "Gabriel García Márquez", "Sudamericana", 5, 3),
(2,"9788441439644", "El Quijote", "Miguel de Cervantes", "Alfaguara", 7, 5),
(3,"9788497595329", "El hobbit", "J.R.R. Tolkien", "Minotauro", 3, 3),
(1,"9788408157435", "La insoportable levedad del ser", "Milan Kundera", "Planeta", 2, 2),
(2,"9786070739264", "1984", "George Orwell", "Debolsillo", 4, 0);


INSERT INTO personas(id_biblioteca, nombre, apellido, nif, contrasenya) VALUES
(1, "Gema", "Marquinez Quiroz", "45610975C","121113456"),
(2, "Juan", "González Perez", "12345678Z", "abc1231111"),
(3, "Maria", "Rodriguez Lopez","87654321A", "qwertyyyy"),
(2, "Pedro", "García Fernández", "98765432B", "zxcvb1111"),
(1, "Laura", "Ruiz Sánchez", "11111111X", "asdfg54555");

