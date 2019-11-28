INSERT INTO user (id , activation_code ,active , email ,password , username)
VALUES (1 ,"activationcode",TRUE,"fiftifiv@gmail.com" ,"admin","admin");

INSERT INTO user_roles (user_id , roles)
VALUES (1,"USER"),(1,"ADMIN");