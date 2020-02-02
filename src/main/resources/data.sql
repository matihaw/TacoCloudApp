delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;

insert into Ingredient (id, name, type)
    values ('FLTO', 'pszenna', 'WRAP');

insert into Ingredient (id, name, type)
    values ('COTO', 'kukurydziana', 'WRAP');

insert into Ingredient (id, name, type)
    values ('GRBF', 'mielona wołowina', 'PROTEIN');

insert into Ingredient (id, name, type)
    values ('CARN', 'kawałki mięsa', 'PROTEIN');

insert into Ingredient (id, name, type)
    values ('TMTO', 'pomidory pokrojone w kostkę', 'VEGGIES');

insert into Ingredient (id, name, type)
    values ('LETC', 'sałata', 'VEGGIES');

insert into Ingredient (id, name, type)
    values ('CHED', 'cheddar', 'CHEESE');

insert into Ingredient (id, name, type)
    values ('JACK', 'Monterey Jack', 'CHEESE');

insert into Ingredient (id, name, type)
    values ('SLSA', 'salsa', 'SAUCE');

insert into Ingredient (id, name, type)
    values ('SRCR', 'śmietana', 'SAUCE');
    

