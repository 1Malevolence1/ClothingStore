CREATE TABLE IF NOT EXISTS  public.category(
    category_id serial primary key,
    category_name varchar(50) unique not null
);



CREATE TABLE IF NOT EXISTS  public.product(
    product_id serial primary key,
    product_name varchar(255) unique not null,
    price integer not null,
    description text,
    stock_quantity integer not null,
    image_url text,
    category_id integer references public.category(category_id)
);
