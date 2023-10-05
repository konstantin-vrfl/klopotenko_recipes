CREATE TABLE my_db.recipes (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(90),
    url varchar(60),
    description varchar(1200),
    is_hot_dish boolean,
    is_vegetarian_dish boolean,
    cooking_time int,
    PRIMARY KEY (id)
);

CREATE TABLE my_db.measures (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(20),
    PRIMARY KEY (id)
);

CREATE TABLE my_db.ingredients (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30),
    is_vegetarian boolean,
    measure_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (measure_id) REFERENCES my_db.measures(id)
);

CREATE TABLE my_db.recipe_ingredient (
    recipe_id int NOT NULL,
    ingredient_id int NOT NULL,
    amount decimal,
    PRIMARY KEY (recipe_id, ingredient_id),
    FOREIGN KEY (recipe_id) REFERENCES my_db.recipes(id),
    FOREIGN KEY (ingredient_id) REFERENCES my_db.ingredients(id)
);