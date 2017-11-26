CREATE TABLE public.category (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR NOT NULL UNIQUE,
  description VARCHAR
);

CREATE TABLE public.product (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR NOT NULL,
  description VARCHAR,
  manufacturer VARCHAR NOT NULL,
  price DECIMAL NOT NULL,
  addition_date TIMESTAMP NOT NULL,
  picture IMAGE,
  category_id BIGINT,
  FOREIGN KEY(category_id) REFERENCES public.category(id)
);

INSERT INTO public.category(name, description) VALUES ('CATEGORY1', 'CATEGORY1');
INSERT INTO public.product(name, description, manufacturer, price, addition_date, picture, category_id)
VALUES (
  'PRODUCT1',
  'CATEGORY1',
  'MANUFACTURER1',
  100,
  PARSEDATETIME('2011-11-11 11:11:11',  'yyyy-MM-dd hh:mm:ss'),
  FILE_READ('classpath:1.jpg'),
  SELECT c.id FROM public.category c WHERE c.name = 'CATEGORY1'
);