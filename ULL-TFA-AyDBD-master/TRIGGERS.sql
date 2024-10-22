-- TRIGGER 1
CREATE OR REPLACE FUNCTION new_register() RETURNS TRIGGER AS $new_register$
    BEGIN
        UPDATE SOCIO 
        SET NUMERO_SOCIO = 1 + (SELECT MAX(NUMERO_SOCIO) FROM SOCIO);
    END;
$new_register$ LANGUAGE plpgsql;
     

CREATE TRIGGER increase_socio AFTER INSERT ON SOCIO
EXECUTE PROCEDURE new_register();

-- TRIGGER 2
CREATE OR REPLACE FUNCTION new_register() RETURNS TRIGGER AS $new_register$
    BEGIN
        UPDATE SOCIO 
        SET new.NUMERO_SOCIO = (SELECT (MAX(NUMERO_SOCIO) - 1) FROM SOCIO);
    END;
$new_register$ LANGUAGE plpgsql;
     

CREATE TRIGGER decrease_socio AFTER INSERT ON SOCIO
EXECUTE PROCEDURE new_register();

-- TRIGGER 3
CREATE OR REPLACE FUNCTION new_register() RETURNS TRIGGER AS $new_register$
    BEGIN
        UPDATE PRODUCTO 
        SET PRECIO = PRECIO * 0.9
        WHERE STOCK > 100;
    END;
$new_register$ LANGUAGE plpgsql;
     

CREATE TRIGGER discount_if_stock_high AFTER INSERT ON SOCIO
EXECUTE PROCEDURE new_register();

-- TRIGGER 4
CREATE OR REPLACE FUNCTION new_register() RETURNS TRIGGER AS $new_register$
    BEGIN
        UPDATE PAGO 
        SET TARIFA = TARIFA * 0.75
        WHERE TARIFA > 150;
    END;
$new_register$ LANGUAGE plpgsql;
     

CREATE TRIGGER discount_high_tax AFTER INSERT ON SOCIO
EXECUTE PROCEDURE new_register();

-- TRIGGER 5 
CREATE OR REPLACE FUNCTION new_register() RETURNS TRIGGER AS $new_register$
    BEGIN
        DELETE FROM SUBSCRITO AS s
				WHERE s.DNI = p.DNI AND 30 > CURRENT_DATE - (SELECT FECHA 
                                                             FROM PAGO AS p);
    END;
$new_register$ LANGUAGE plpgsql;
     

CREATE TRIGGER end_subscription AFTER INSERT ON SOCIO
EXECUTE PROCEDURE new_register();
