CREATE OR REPLACE
PROCEDURE listar_clasificacion (in_clasificacion IN NUMBER) AS
 titulo_correspondiente VARCHAR2(50);
 TYPE mi_cursor IS REF CURSOR;
 el_cursor mi_cursor;
BEGIN
 OPEN el_cursor 
 FOR 'SELECT titulo
 FROM libros
 WHERE clasificacion = :in_clasificacion'
 USING in_clasificacion;
 DBMS_OUTPUT.PUT_LINE('Todos los libros con una clasificacion de ' || in_clasificacion || ':');
 LOOP
 FETCH el_cursor INTO titulo_correspondiente;
 EXIT WHEN el_cursor%NOTFOUND;
 DBMS_OUTPUT.PUT_LINE(titulo_correspondiente);
 END LOOP;
 CLOSE el_cursor;
END listar_clasificacion;