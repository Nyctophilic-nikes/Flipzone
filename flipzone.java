import java.util.*;

interface userInterface{
    //interface for the Admin and the customer class
    String getUsername();
    String getPassword();

}

class Admin implements userInterface{
    final private String username = "Beff Jezos";

    @Override
    public String getUsername(){return this.username;}
    final private String password = "********";
    @Override
    public String getPassword(){return this.password;}
    static Scanner input = new Scanner(System.in);

    public static boolean logIn(){
        System.out.println("Dear Admin, Please Enter your username and password");
        input.nextLine();
        System.out.println("Enter the Admin Name: ");
        String username = input.nextLine();
//        System.out.println(username);
        System.out.println("Enter the password: ");
        String password = input.nextLine();
//        System.out.println(password);
        return username.equals("Beff Jezos") && password.equals("********");
    }

    public static category getCategory(int categoryID){
        //method to get the category from the database
        for(int i = 0; i < database.categoryList.size(); i++){
            category temp = database.categoryList.get(i);
            if(temp.getCategoryID() == categoryID){
                return temp;
            }
        }
        return null;
    }

    public static product getProduct(category category, float productID){
        //method to get product from the category
        for(int i = 0; i < category.getProductList().size(); i++){
            product temp = category.getProductList().get(i);
            if(temp.getProductID() == productID){
                return temp;
            }
        }
        return null;
    }

    //method overloading
    public static product getProduct(float productID){
        //method to get product from the category
        for(int i = 0; i < database.productList.size() ; i++){
            product temp = database.productList.get(i);
            if(temp.getProductID() == productID){
                return temp;
            }
        }
        return null;
    }

    public static boolean checkCategoryExist(int categoryID){
        //method to check category exist or not
        for(int i = 0; i < database.categoryList.size(); i++){
            if(database.categoryList.get(i).getCategoryID() == categoryID){
                return true;
            }
        }
        return false;
    }

    public static boolean checkProductExist(float productID){
        //method to check product exist or not
        for(int i = 0; i < database.productList.size(); i++){
            if(database.productList.get(i).getProductID() == productID){
                return true;
            }
        }
        return false;
    }

    public static boolean checkDealExist(int dealID){
        //method to check deal exist or not
        for (int i = 0; i < database.giveAwayDeals.size(); i++){
            if(dealID == database.giveAwayDeals.get(i).getDealID()){
                return true;
            }
        }
        return false;
    }


    //method overloading
    public static deals getDeal(product product){
        //method to get deal via product
        for(int i = 0; i < database.giveAwayDeals.size(); i++){
            deals deal = database.giveAwayDeals.get(i);
            if(product == deal.getDealProducts().get(0) || product == deal.getDealProducts().get(1)){
                return deal;
            }
        }
        return null;
    }

    public static deals getDeal(int dealId){
        //method to get deal via product
        for(int i = 0; i < database.giveAwayDeals.size(); i++){
            deals deal = database.giveAwayDeals.get(i);
            if(deal.getDealID() == dealId){
                return deal;
            }
        }
        return null;
    }

}

interface categoryInterface{
    //interface to implement category
    int getCategoryID();
    void setCategoryID(int categoryID);
    String getCategoryName();
    void setCategoryName(String categoryName);
}

class category implements categoryInterface{
    // category class which includes category name; id; products

    //category id
    private int categoryID;
    @Override
    public int getCategoryID(){return this.categoryID;}
    @Override
    public void setCategoryID(int categoryID){this.categoryID = categoryID;}

    //category name
    private String categoryName;

    @Override
    public String getCategoryName(){return this.categoryName;}
    @Override
    public void setCategoryName(String categoryName){this.categoryName = categoryName;}

    //Array List for product
    private ArrayList<product> productList = new ArrayList<>();
    public ArrayList<product> getProductList() {return productList;}
    public void setProductList(ArrayList<product> productList) {this.productList = productList;}

    category(int categoryID, String categoryName, ArrayList<product> productList){
        this.setCategoryID(categoryID);
        this.setCategoryName(categoryName);
        this.setProductList(productList);
        System.out.println("hurray Category created!");
    }
}

interface productInterface{
    //interface for product
    String getProductName();
    void setProductName(String productName);

    //product id
    float getProductID();
    void setProductID(float productID);

    //product price
    float getProductPrice();
    void setProductPrice(float productPrice);

    //product quantity
    int getProductQuantity();
    void setProductQuantity(int productQuantity
    );
}

class product implements productInterface{
    //product class
    //product name
    private String productName;
    @Override
    public String getProductName(){return this.productName;}
    @Override
    public void setProductName(String productName){this.productName = productName;}

    //product ID
    private float productID;
    @Override
    public float getProductID(){return this.productID;}
    @Override
    public void setProductID(float productID){this.productID = productID;}

    //product price
    private float productPrice;
    @Override
    public float getProductPrice(){return productPrice;}
    @Override
    public void setProductPrice(float productPrice){this.productPrice = productPrice;}

    //product quantity
    private int productQuantity;
    @Override
    public int getProductQuantity(){return this.productQuantity;}
    @Override
    public void setProductQuantity(int productQuantity){this.productQuantity = productQuantity;}


    //List of product details
    private ArrayList<String> productDetails = new ArrayList<>();
    public ArrayList<String> getProductDetails() {return productDetails;}
    public void setProductDetails(ArrayList<String> productDetails) {this.productDetails = productDetails;}

    //product category
    private category category;
    public category getCategory() {return category;}
    public void setCategory(category category) {this.category = category;}

    product(String productName, float productID, float productPrice,int productQuantity, ArrayList<String> productDetails, category category){
        this.setProductName(productName);
        this.setProductID(productID);
        this.setProductPrice(productPrice);
        this.setProductQuantity(productQuantity);
        this.setProductDetails(productDetails);
        this.setCategory(category);
        System.out.println("hurray product created!");

    }
}

//inheritance
class addCategory extends Admin{
    public static void AddCategory() {
        //method to add category
        boolean flag = false;
        while (!flag) {
            System.out.println("Add the Category ID: ");
            int categoryID = input.nextInt();
//            System.out.println(categoryID);
            boolean validCategory;
            input.nextLine();
            validCategory = checkCategoryExist(categoryID);
            if (validCategory) {System.out.println("This Category Already Exist"); continue;}
            System.out.println("Add the Name of the Category: ");
            String categoryName = input.nextLine();
//            System.out.println(categoryName);
            //todo: to add product thing and creating the category
            ArrayList<product> productList = new ArrayList<>();
            category category = new category(categoryID,categoryName,productList);
            addProduct.AddProduct(category);
            database.categoryList.add(category);
            flag = true;
        }
    }
}

class deleteCategory extends Admin{
    public static void DeleteCategory() {
        //method to delete the category
        boolean flag = false;
        if (database.categoryList.size() > 0) {
            while (!flag) {
                System.out.println("ID of the Category to delete: ");
                int categoryID = input.nextInt();
//            input.nextLine();
//                System.out.println(categoryID);
                category category = getCategory(categoryID);
                if (category == null) {
                    System.out.println("The category ID doesn't exist!!");

                } else {
                    System.out.println("Are you Sure you want to delete the category :( " + category.getCategoryName() + " (y/n): ");
                    String yesNo = input.next();
//                    System.out.println(yesNo);
                    if (yesNo.equals("y")) {
                        System.out.println("Enter your password: ");
                        String password = input.next();
                        if (password.equals("********")) {
                            for (int i = 0; i < category.getProductList().size(); i++) {
                                product product = category.getProductList().get(i);
                                deals deal = getDeal(product);
                                if (deal != null) {
                                    database.giveAwayDeals.remove(deal);
                                }
                                database.productList.remove(product);
                            }
                            System.out.println("All Products of the category has been deleted.");
                            database.categoryList.remove(category);
                            System.out.println("category deleted! :(");
                            flag = true;
                        } else {
                            System.out.println("Wrong PassWord!!!!!!!!!!!!");
                        }
                    } else {
                        System.out.println(":) Category hasn't been deleted");
                        flag = true;

                    }
                }
            }
        }else{System.out.println("No categories to delete!");}
    }
}

class addProduct extends Admin{
    public static void AddProduct(category category) {
        //method to add product
        boolean flag = false;
        while(!flag) {
//            input.nextLine();
            System.out.println("Add a product:- ");
            System.out.println("Product Name: ");
            String productName = input.nextLine();
//            System.out.println(productName);

            System.out.println("Product ID: ");
            float productID = input.nextFloat();
//                input.nextLine();
//            System.out.println(productID);
            boolean validProduct = checkProductExist(productID);
            if (validProduct) {
                System.out.println("Product Already Exist!!");
                continue;
            }

            System.out.println("Product price: ");
            float productPrice = input.nextFloat();
//            input.nextLine();
//            System.out.println(productPrice);
            System.out.println("Product quantity: ");
            int productQuantity = input.nextInt();
//            input.nextLine();
//            System.out.println(productQuantity);
            ArrayList<String> productDetails = new ArrayList<>();
            System.out.println("Would you like to add more details(y/n): ");
            String yesNo = input.next();
//            System.out.println(yesNo);
            if (yesNo.equals("y")) {
                System.out.println("Number of details you would to add: ");
                int details = input.nextInt();
                //todo: product details numeration
//                System.out.println(details);
                System.out.println("Add Details:- ");
                input.nextLine();
                for (int i = 0; i < details; i++) {
                    String Detail = input.nextLine();
//                    System.out.println(Detail);
                    productDetails.add(Detail);

                }
                product product = new product(productName, productID, productPrice, productQuantity, productDetails, category);
                category.getProductList().add(product);
                database.productList.add(product);
            }else if(yesNo.equals("n")){
                product product = new product(productName, productID, productPrice, productQuantity, productDetails, category);
                category.getProductList().add(product);
                database.productList.add(product);
                input.nextLine();
            }
            flag = true;

        }
    }

}

class deleteProduct extends Admin{
    public static void DeleteProduct(category category) {
        // method to delete product
        boolean flag = false;
        if (database.productList.size() > 0) {
            while (!flag) {
                System.out.println("ID of the product to delete: ");
                float productID = input.nextFloat();
//            input.nextLine();
                System.out.println(productID);
                product product = getProduct(category, productID);
                if (product == null) {
                    System.out.println("The product ID doesn't exist!!");
                    flag = true;
                } else {
                    System.out.println("Are you sure you want to delete the product :( " + product.getProductName() + " (y/n): ");
                    String yesNo = input.next();
//                    System.out.println(yesNo);
                    if (yesNo.equals("y")) {
                        System.out.println("Enter your password: ");
                        String password = input.next();
                        System.out.println(password);
                        if (password.equals("********")) {
                            for (int i = 0; i < category.getProductList().size(); i++) {
                                product temp = category.getProductList().get(i);
                                if (temp.getProductID() == productID) {
                                    if (category.getProductList().size() == 1) {
                                        System.out.println("You can't leave category empty!! would you like to delete category? " + category.getCategoryName() + " (y/n): ");
                                        String yesNo2 = input.next();
                                        if (yesNo2.equals("y")) {
                                            database.categoryList.remove(category);
                                            database.productList.remove(temp);
                                            System.out.println("The product has been successfully deleted :(");
                                            flag = true;
                                        } else {
                                            flag = true;
                                        }
                                    } else {
                                        deals deal = getDeal(temp);
                                        if (deal != null) {
                                            database.giveAwayDeals.remove(deal);
                                        }
                                        category.getProductList().remove(temp);
                                        database.productList.remove(temp);
                                        System.out.println("The product has been successfully deleted :(");
                                        flag = true;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Wrong PassWord!!!!!!!!!!!!");
                        }
                    } else {
                        System.out.println(":) Category hasn't been deleted");
                        flag = true;
                    }
                }

            }

        }else{System.out.println("No products to delete!!");}
    }
}

class setDiscount extends Admin{
    public static void SetDiscount(){
        System.out.println("Enter product ID: ");
        float productID = input.nextFloat();
        product product = getProduct(productID);
        System.out.println("For Elite: ");
        int elite = input.nextInt();
        System.out.println("For Prime: ");
        int prime = input.nextInt();
        System.out.println("For Normal: ");
        int normal = input.nextInt();
        discount discount = new discount(product,elite,prime,normal);
        database.DiscountedProduct.add(discount);
    }
}

class discount{
    product product;
    int elite;
    int prime;
    int normal;

    discount(product product, int elite, int prime, int normal){
        this.product = product;
        this.elite = elite;
        this.prime = prime;
        this.normal = normal;
    }
}
class addGiveAwayDeals extends Admin{
    public static void AddGiveAwayDeal(){
        boolean flag = false;
        while (!flag){
            boolean validProduct;
            float productID1;
            float productID2;
            float dealPrice;
            int dealID;
            String dealName;
            product product1;
            product product2;
            boolean validDealID;
            System.out.println("Add the deal ID: ");
            dealID = input.nextInt();
//            System.out.println(dealID);
            input.nextLine();
            validDealID = checkDealExist(dealID);
            if(validDealID){System.out.println("This deal ID already exist!!");continue;}
            System.out.println("Add the deal Name: ");
            dealName = input.nextLine();
//            System.out.println(dealName);
//            input.nextLine();
            System.out.println("Dear Admin, give the Product ID you want to combine and giveaway a deal for: ");
            System.out.println("Enter the first Product ID: ");
            productID1 = input.nextFloat();
//            System.out.println(productID1);
//            input.nextLine();
            validProduct = checkProductExist(productID1);
            if(!validProduct){System.out.println("Sorry the product doesn't exist or out of the stock"); continue;}
            else{
                product1 = getProduct(productID1);
                System.out.println("Enter the second product ID: ");
                productID2 = input.nextFloat();
//                System.out.println(productID2);
                validProduct = checkProductExist(productID2);
                if(!validProduct){System.out.println("Sorry the product doesn't exist or out of the stock"); continue;}
                else{product2 = getProduct(productID2);}
            }
            ArrayList<product> temp = new ArrayList<>();
            temp.add(0,product1);
            temp.add(1,product2);
            float totalPrice = 0;
            if (product2 != null && product1 != null) {
                totalPrice = product1.getProductPrice() + product2.getProductPrice();
            }
            System.out.println("The deal should be less than " + String.valueOf(totalPrice));
            System.out.println("Enter the deal price: ");
            dealPrice = input.nextFloat();
//            input.nextLine();
//            System.out.println(dealPrice);
            deals newDeal = new deals(dealID,dealName,temp,dealPrice);
            database.giveAwayDeals.add(newDeal);
            flag = true;
        }
    }
}


class deals{
    //deal ID
    private int dealID;
    public int getDealID(){return this.dealID;}
    public void setDealID(int dealID){this.dealID = dealID;}

    //deal name
    private String dealName;
    public String getDealName(){return this.dealName;}
    public void setDealName(String dealName){this.dealName = dealName;}

    //products on the deal
    private ArrayList<product> dealProducts = new ArrayList<>();
    public ArrayList<product> getDealProducts(){return  this.dealProducts;}
    public void setDealProducts(ArrayList<product> dealProducts){this.dealProducts = dealProducts;}

    //deal price
    private float dealPrice;
    public float getDealPrice(){return this.dealPrice;}
    public void setDealPrice(float dealPrice){this.dealPrice = dealPrice;}

    deals(int dealID, String dealName, ArrayList<product> dealProducts, float dealPrice){
        this.setDealID(dealID);
        this.setDealName(dealName);
        this.setDealProducts(dealProducts);
        this.setDealPrice(dealPrice);
        System.out.println("Hurray! Deal is created");

    }
}

class exploreProductCatalogue{
    public static void ProductCatalogue(){
        if(database.categoryList.size()>0){
            int m = 0;
            int n = 0;
            System.out.println("The Product Catalogue:-");
            for(int i = 0; i < database.categoryList.size(); i++){
                m = i + 1;
                category category = database.categoryList.get(i);
                System.out.println(m+":-");
                System.out.println("Category Name:  " + category.getCategoryName());
                System.out.println("Category ID:    " + category.getCategoryID());
                for(int j = 0; j < category.getProductList().size(); j++){
                    n = j + 1;
                    product product = category.getProductList().get(j);
                    System.out.println("    "+n+":-");
                    System.out.println("    Product Name:       " + product.getProductName());
                    System.out.println("    Product ID:         "+ product.getProductID());
                    System.out.println("    Product Price:      "+ "Rs "+product.getProductPrice()+"/-");
                    System.out.println("    Product Quantity:   "+ product.getProductQuantity()+" units");
                    for(int k = 0; k < product.getProductDetails().size(); k++){
                        String detail = product.getProductDetails().get(k);
                        System.out.println("    "+detail);
                    }

                }
            }
        }else{System.out.println("There are no product to show for now :( !! Return back soon for exiting products.");}
    }
}

class showAvailableDeals{
    public static void Show(){
        if(database.giveAwayDeals.size()>0) {
            int j = 0;
            System.out.println("The Available deals:- ");
            for (int i = 0; i < database.giveAwayDeals.size(); i++) {
                deals deal = database.giveAwayDeals.get(i);
                j = i + 1;
                System.out.println(j+":-");
                System.out.println("Deal Name:      " + deal.getDealName());
                System.out.println("Deal ID:        " + deal.getDealID());
                System.out.println("Deal Products:  " + deal.getDealProducts().get(0).getProductName() + " + " + deal.getDealProducts().get(1).getProductName());
                System.out.println("Deal Price:     " + "Rs "+deal.getDealPrice()+"/-");

            }
        }
        else{
            System.out.println("Dear User, there are no deals for now :( !! Please check regularly for exciting deals.");
        }
    }
}

//=================================================================================================================================================================
//Customer Services
interface CustomerInterface{
    //interface for customer

    ///age
    int getAge();
    void setAge(int age);

    //phone Number
    long getPhoneNo();
    void setPhoneNo(long phoneNo);

    //email
    String getEmail();
    void setEmail(String email);

}

class customer implements userInterface, CustomerInterface{
    static Scanner input = new Scanner(System.in);
    private String userName;
    @Override
    public String getUsername(){return this.userName;}
    public void setUsername(String userName){this.userName = userName;}

    private String passWord;
    @Override
    public String getPassword(){return this.passWord;}
    public void setPassword(String passWord){this.passWord = passWord;}

    private int age;
    @Override
    public int getAge(){return this.age;}
    public void setAge(int age){this.age = age;}

    private long phoneNo;
    @Override
    public long getPhoneNo() {return this.phoneNo;}
    public void setPhoneNo(long phoneNo){this.phoneNo = phoneNo;}

    private String email;
    @Override
    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    private ArrayList<product> cart = new ArrayList<>();
    public ArrayList<product> getCart(){return this.cart;}
    public void setCart(ArrayList<product> cart){this.cart = cart;}

    private ArrayList<deals> dealCart = new ArrayList<>();
    public ArrayList<deals> getDealCart(){return this.dealCart;}
    public void setDealCart(ArrayList<deals> dealCart){this.dealCart = dealCart;}

    private float wallet;
    public float getWallet(){return this.wallet;}
    public void setWallet(float wallet){this.wallet = wallet;}

    private ArrayList<Integer> coupons = new ArrayList<>();
    public ArrayList<Integer> getCoupons(){return this.coupons;}
    public void setCoupons(ArrayList<Integer> coupons){this.coupons = coupons;}

    private String Status;
    public String getStatus(){return this.Status;}
    public void setStatus(String status){this.Status = status;}

    customer(String userName, String passWord, int money,String Status,ArrayList<Integer> coupons){
        setUsername(userName);
        setPassword(passWord);
        setWallet(money);
        setStatus(Status);
        setCoupons(coupons);

    }

    public static void signUp(){
        boolean flag = false;
        while(!flag) {
            input.nextLine();
            System.out.println("Enter name: ");
            String userName = input.nextLine();
//        System.out.println(userName);
            System.out.println("Enter password: ");
            String passWord = input.next();
            customer validCustomer = getCustomer(userName,passWord);
            if(validCustomer==null){
                int money = 1000;
                String Status = "NORMAL";
                ArrayList<Integer> coupons = new ArrayList<>();
                coupons.add(10);
                customer newCustomer = new customer(userName, passWord, money, Status, coupons);
                System.out.println("customer successfully Registered!!");
                database.customerList.add(newCustomer);
            }
            else {System.out.println("Customer Already Exist!");}
            flag = true;
//        System.out.println(passWord);

        }
    }

    public static customer login(){
        input.nextLine();
        System.out.println("Enter name: ");
        String userName = input.nextLine();
//        System.out.println(userName);
        System.out.println("Enter password: ");
        String passWord = input.next();
//        System.out.println(passWord);
        customer validCustomer = getCustomer(userName,passWord);
        if(validCustomer!=null){
            return validCustomer;
        }
        return null;
    }

    public static void addProductToCart(customer customer){
        boolean flag = false;
        while(!flag) {
            System.out.println("Enter the Product Id");
            float productId = input.nextFloat();
            product validProduct = Admin.getProduct(productId);
            if (validProduct != null) {
                if(validProduct.getProductQuantity() != 0) {
                    System.out.println("Enter the Quantity: ");
                    int productQuantity = input.nextInt();
                    if(productQuantity < validProduct.getProductQuantity()){
                        for(int i = 0; i < productQuantity; i++){customer.getCart().add(validProduct);}
                        validProduct.setProductQuantity(validProduct.getProductQuantity()-productQuantity);
                        System.out.println("Item Successfully added to the cart!!");
                        flag = true;
                    } else{System.out.println("Not enough Quantity of product available!");}
                }else{System.out.println("The product is out of the stock!");}
            } else {
                System.out.println("Invalid product ID!!");
            }
        }
    }

    public static void viewCoupons(customer customer){
        boolean flag = false;
        while(!flag){
            int j = 1;
            if(customer.getCoupons().size()>0) {
                for (int i = 0; i < customer.getCoupons().size(); i++) {
                    int coupon = customer.getCoupons().get(i);
                    System.out.println(j++ + ":-");
                    System.out.println(coupon+"%");
                }
            }else{
                System.out.println("No coupons Available!");
            }
            flag = true;
        }
    }

    public static void addDealsToCart(customer customer){
        boolean flag = false;
        while(!flag) {
            System.out.println("Enter the Deal Id: ");
            int dealId = input.nextInt();
            deals validDeal = Admin.getDeal(dealId);
            if (validDeal != null) {
                customer.getDealCart().add(validDeal);
                System.out.println("Item Successfully added to the cart!!");
                flag = true;
            } else {
                System.out.println("Invalid product ID!!");
            }
        }
    }

    public static void CheckBalance(customer customer){
        boolean flag = false;
        while(!flag){
            System.out.println("Current account balance is Rupees: ");
            System.out.println("Rs "+customer.getWallet()+"/-");
            flag = true;
        }
    }

    public static void viewCart(customer customer){
        if(customer.getDealCart().size()>0 || customer.getCart().size()>0) {
            boolean flag = false;
            while (!flag) {
                float Total = 0;
                float MainTotal = 0;
                int j = 1;
                System.out.println("Items in the cart: ");
                for (int i = 0; i < customer.getCart().size(); i++) {
                    product product = customer.getCart().get(i);
                    System.out.println(j++ + ":-");
                    discount discount = getDiscount(product);
                    if (discount == null) {
                        float dPrice = 0;
                        if (customer.getStatus().equals("NORMAL")) {
                            dPrice = product.getProductPrice();
                        } else if (customer.getStatus().equals("PRIME")) {
                            float temp1 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (5 / (100.0))));
                            dPrice = temp1;
                        } else if (customer.getStatus().equals("ELITE")) {
                            float temp1 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (10 / (100.0))));
                            dPrice = temp1;
                        }
                        System.out.println("Product Name:   " + product.getProductName());
                        System.out.println("Product ID:     " + product.getProductID());
                        System.out.println("Product Price:  " + "Rs "+dPrice+"/-");
                        Total = Total + dPrice;
                    } else {
                        float dPrice = 0;
                        if (customer.getStatus().equals("NORMAL")) {
                            float temp1 = (float) (product.getProductPrice() - product.getProductPrice() * (discount.normal / (100.0)));
                            dPrice = temp1;
                        } else if (customer.getStatus().equals("PRIME")) {
                            float temp1 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (discount.prime / (100.0))));
                            float temp2 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (5 / (100.0))));
                            dPrice = Math.max(temp1, temp2);
                        } else if (customer.getStatus().equals("ELITE")) {
                            float temp1 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (discount.elite / (100.0))));
                            float temp2 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (10 / (100.0))));
                            dPrice = Math.max(temp1, temp2);
                        }
                        System.out.println("Product Name:   " + product.getProductName());
                        System.out.println("Product ID:     " + product.getProductID());
                        System.out.println("Product Price:  " + "Rs "+dPrice+"/-");
                        Total = Total + dPrice;

                    }
                    //todo discount thing
                }
                for (int k = 0; k < customer.getDealCart().size(); k++) {
                    deals deal = customer.getDealCart().get(k);
                    System.out.println(j++ + ":-");
                    System.out.println("Deal Name:  " + deal.getDealName());
                    System.out.println("Deal ID:    " + deal.getDealID());
                    System.out.println("Deal Price: " + "Rs "+deal.getDealPrice()+"/-");
                    Total = Total + deal.getDealPrice();
                }
                float delivery = 0;
                float Max = 0;
                if (customer.getStatus().equals("NORMAL")) {
                    delivery = (float) (100 + (Total * 0.05));
//                float Max = 0;
                    if (customer.getCoupons().size() > 0) {
                        for (int i = 0; i < customer.getCoupons().size(); i++) {
                            int temp = customer.getCoupons().get(i);
                            Max = Math.max(Max, temp);
                        }
                        System.out.println(Max+"%" + " coupon Applied!");
                    }

                } else if (customer.getStatus().equals("PRIME")) {
                    delivery = (float) (100 + (Total * 0.02));
//                float Max = 0;
                    if (customer.getCoupons().size() > 0) {
                        for (int i = 0; i < customer.getCoupons().size(); i++) {
                            int temp = customer.getCoupons().get(i);
                            Max = Math.max(Max, temp);
                        }
                        System.out.println(Max+"%" + " coupon Applied!");
                    }
                } else if (customer.getStatus().equals("ELITE")) {
                    delivery = 100;
//                float Max = 0;
                    if (customer.getCoupons().size() > 0) {
                        for (int i = 0; i < customer.getCoupons().size(); i++) {
                            int temp = customer.getCoupons().get(i);
                            Max = Math.max(Max, temp);
                        }
                        System.out.println(Max+"%" + " coupon Applied!");
                    }
                }
                if (Max > 0) {
                    MainTotal = Total - (Total * (Max / 100));
                } else {
                    MainTotal = Total;
                }
                System.out.println("Your Total Amount:  " + "Rs "+MainTotal+"/-");
                System.out.println("Delivery Charges:   " + "Rs "+delivery+"/-");
                float grandTotal = MainTotal + delivery;
                System.out.println("Grand Total:    " + "Rs "+grandTotal+"/-");
                flag = true;
            }
        }else{System.out.println("The cart is empty!!");}
    }

    public static discount getDiscount(product product){
        for(int i = 0; i < database.DiscountedProduct.size(); i++){
            discount temp = database.DiscountedProduct.get(i);
            if(temp.product == product){
                return temp;
            }
        }
        return null;
    }

    public static void emptyCart(customer customer){
        boolean flag = false;
        while(!flag){
            for(int i = 0; i < customer.getCart().size(); i++){
                product product = customer.getCart().get(i);
                customer.getCart().removeAll(customer.getCart());
            }
            for(int i = 0; i < customer.getDealCart().size(); i++){
                deals deal = customer.getDealCart().get(i);
                customer.getDealCart().remove(deal);
            }
            System.out.println("Your Cart has been successfully emptied!!");
            flag = true;

        }
    }

    public static void checkOut(customer customer){
        if(customer.getCart().size()>0 || customer.getDealCart().size()>0) {
            boolean flag = false;
            while (!flag) {
                System.out.println("Proceeding to Checkout...");
                float Total = 0;
                float MainTotal = 0;
                int j = 1;
                System.out.println("Items in the cart:- ");
                for (int i = 0; i < customer.getCart().size(); i++) {
                    product product = customer.getCart().get(i);
                    System.out.println(j++ + ")");
                    discount discount = getDiscount(product);
                    if (discount == null) {
                        float dPrice = 0;
                        if (customer.getStatus().equals("NORMAL")) {
                            dPrice = product.getProductPrice();
                        } else if (customer.getStatus().equals("PRIME")) {
                            float temp1 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (5 / (100.0))));
                            dPrice = temp1;
                        } else if (customer.getStatus().equals("ELITE")) {
                            float temp1 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (10 / (100.0))));
                            dPrice = temp1;
                        }
                        System.out.println("Product Name:   " + product.getProductName());
                        System.out.println("Product ID:     " + product.getProductID());
                        System.out.println("Product Price:  " + "Rs "+dPrice+"/-");
                        Total = Total + dPrice;
                    } else {
                        float dPrice = 0;
                        if (customer.getStatus().equals("NORMAL")) {
                            float temp1 = (float) (product.getProductPrice() - product.getProductPrice() * (discount.normal / (100.0)));
                            dPrice = temp1;
                        } else if (customer.getStatus().equals("PRIME")) {
                            float temp1 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (discount.prime / (100.0))));
                            float temp2 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (5 / (100.0))));
                            dPrice = Math.max(temp1, temp2);
                        } else if (customer.getStatus().equals("ELITE")) {
                            float temp1 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (discount.elite / (100.0))));
                            float temp2 = (float) ((product.getProductPrice()) - (product.getProductPrice() * (10 / (100.0))));
                            dPrice = Math.max(temp1, temp2);
                        }
                        System.out.println("Product Name:   " + product.getProductName());
                        System.out.println("Product ID:     " + product.getProductID());
                        System.out.println("Product Price:  " + "Rs "+dPrice+"/-");
                        Total = Total + dPrice;

                    }
                    //todo discount thing
                }
                for (int k = 0; k < customer.getDealCart().size(); k++) {
                    deals deal = customer.getDealCart().get(k);
                    System.out.println(j++ + ":-");
                    System.out.println("Deal Name:  " + deal.getDealName());
                    System.out.println("Deal ID:    " + deal.getDealID());
                    System.out.println("Deal Price: " + "Rs "+deal.getDealPrice()+"/-");
                    Total = Total + deal.getDealPrice();
                }
                float delivery = 0;
                float Max = 0;
                if (customer.getStatus().equals("NORMAL")) {
                    delivery = (float) (100 + (Total * 0.05));
//                float Max = 0;
                    if (customer.getCoupons().size() > 0) {
                        for (int i = 0; i < customer.getCoupons().size(); i++) {
                            int temp = customer.getCoupons().get(i);
                            Max = Math.max(Max, temp);
                        }
                        System.out.println(Max+"%" + " coupon Applied!");
                    }

                } else if (customer.getStatus().equals("PRIME")) {
                    delivery = (float) (100 + (Total * 0.02));
//                float Max = 0;
                    if (customer.getCoupons().size() > 0) {
                        for (int i = 0; i < customer.getCoupons().size(); i++) {
                            int temp = customer.getCoupons().get(i);
                            Max = Math.max(Max, temp);
                        }
                        System.out.println(Max+"%" + " coupon Applied!");
                    }
                } else if (customer.getStatus().equals("ELITE")) {
                    delivery = 100;
//                float Max = 0;
                    if (customer.getCoupons().size() > 0) {
                        for (int i = 0; i < customer.getCoupons().size(); i++) {
                            int temp = customer.getCoupons().get(i);
                            Max = Math.max(Max, temp);
                        }
                        System.out.println(Max+"%" + " coupon Applied!");
                    }
                }
                if (Max > 0) {
                    MainTotal = Total - (Total * (Max / 100));
                } else {
                    MainTotal = Total;
                }
                System.out.println("Your Total Amount:  " + "Rs "+MainTotal+"/-");
                System.out.println("Delivery Charges:   " + "Rs "+delivery+"/-");
                float grandTotal = MainTotal + delivery;
                System.out.println("Grand Total:    " + "Rs "+grandTotal+"/-");

                if (grandTotal > customer.getWallet()) {
                    System.out.println("Not sufficient Balance!!");
                    flag = true;
                } else {
                    customer.setWallet(customer.getWallet() - grandTotal);
                    System.out.println("Order Placed!!");
                    emptyCart(customer);

                    Random r = new Random();
                    if (customer.getStatus().equals("NORMAL")) {
                        System.out.println("Your Order will be delivered in " + r.nextInt(7,10) + " days");
                    } else if (customer.getStatus().equals("PRIME")) {
                        System.out.println("Your Order will be delivered in " + r.nextInt(3,6) + " days");
                        if (grandTotal > 5000) {
                            int coupons = r.nextInt(1,2);
                            System.out.println("You have received " + coupons + " coupons!");
                            for (int i = 0; i < coupons; i++) {
                                int temp = r.nextInt(10,15);
                                customer.getCoupons().add(temp);
                                System.out.println(temp+"%");
                            }
                        }
                    } else if (customer.getStatus().equals("ELITE")) {
                        System.out.println("It will be delivered in 2 days");
                        if (grandTotal > 5000) {
                            int coupons = r.nextInt(3,4);
                            System.out.println("You have received " + coupons + " coupons!");
                            for (int i = 0; i < coupons; i++) {
                                int temp = r.nextInt(10,15);
                                customer.getCoupons().add(temp);
                                System.out.println(temp+"%");

                            }
                        }
                    }
                }
                flag = true;
            }
        }else{System.out.println("The cart is empty!!");}

    }

    public static void upgradeStatus(customer customer){
        boolean flag = false;
        while(!flag){
            System.out.println("Current status: " + customer.getStatus());
            String Status = input.next();
            customer.setStatus(Status);
            if(Status.equals("ELITE")){
                customer.setWallet(customer.getWallet()-300);
            }
            else if(Status.equals("PRIME")){
                customer.setWallet(customer.getWallet()-200);
            }
            System.out.println("Status Successfully updated! to "+Status);
            flag = true;
        }
    }

    public static void addAmount(customer customer){
        boolean flag = false;
        while(!flag){
            System.out.println("Current balance: "+ "Rs "+customer.getWallet()+"/-");
            float money = input.nextFloat();
            float total = money+customer.getWallet();
            customer.setWallet(total);
            System.out.println("Amount Successfully Added!");
            flag = true;
        }
    }

    public static customer getCustomer(String userName, String passWord){
        for(int i = 0; i < database.customerList.size(); i++){
            customer customer = database.customerList.get(i);
            if(customer.getUsername().equals(userName) && customer.getPassword().equals(passWord)){
                return customer;
            }
        }
        return null;
    }

}

class database{
    // List of category in the database
    static ArrayList<category> categoryList;
    static {
        categoryList = new ArrayList<>();
    }

    // List of all the products in the store
    static ArrayList<product> productList;
    static{
        productList = new ArrayList<>();
    }

    // List of give away deals
    static ArrayList<deals> giveAwayDeals;
    static {
        giveAwayDeals = new ArrayList<>();
    }

    //List of all the customers
    static ArrayList<customer> customerList;
    static{
        customerList = new ArrayList<>();
    }

    //List of discounted product
    static ArrayList<discount> DiscountedProduct;
    static {
        DiscountedProduct = new ArrayList<>();
    }
}
class menus{
    //class to print the menus

    //first page main menu
    public static void welcome(){
        System.out.println("""
WELCOME TO FLIPZONE
    1) Enter as Admin
    2) Explore the Product Catalog
    3) Show Available Deals
    4) Enter as Customer
    5) Exit the Application
Enter the choice:""");
    }

    //entering as admin menu
    public static void EnterAsAdmin(){
        System.out.println(""" 
Please choose any one of the following actions:
    1) Add Category
    2) Delete Category
    3) Add Product
    4) Delete Product
    5) Set Discount on Product
    6) Add giveaway deal
    7) Back
Enter the choice:""");
    }

    public static void Choice3(){
        System.out.println("""
Choose:
    1) add new Category
    2) Change the input
    3) Go back""");
    }

    public static void Choice4(){
        System.out.println("""
Choose:
    1) Change the input
    2) Go back""");
    }

    public static void customerMenu(){
        System.out.println("""
1) Sign up
2) Log in
3) Back""");
    }

    public static void enterCustomer(){
        System.out.println("""
1) browse Material
2) browse deals
3) add a product to cart
4) add products deal in cart
5) view coupons
6) check account balance
7) view cart
8) empty cart
9) checkout cart
10) upgrade Customer status
11) Add amount to wallet
12) back
Enter the choice""");
    }

}


public class flipzone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean welcomeFlag = false; //flag until user doesn't exi//
        while (!welcomeFlag) {
//                try {
            menus.welcome();
            int welcome = input.nextInt();
//            input.nextLine();
//            System.out.println(welcome);
            switch (welcome) {       // Enter in th main menu
                //admin
                case 1 -> {            // case 1 Enter as the admin
                    boolean enterFlag = false;
                    while (!enterFlag) {
                        boolean validAdmin;
                        validAdmin = Admin.logIn();  //checking whether admin is valid or not
//                          System.out.println("validAdmin");
                        if (!validAdmin) {
                            System.out.println("Wrong Username or Password!!!!!!");
                        }
                        //todo: making login accessible or not
                        else {
                            System.out.println("Welcome Beff!!!!!!!");
                            boolean AdminChoiceFlag = false;
                            while (!AdminChoiceFlag) {
                                menus.EnterAsAdmin();
                                int AdminChoice = input.nextInt();
//                                input.nextLine();
//                                System.out.println(AdminChoice);
                                switch (AdminChoice) {
                                    case 1 -> {
                                        addCategory.AddCategory();
                                    } //Add category
                                    case 2 -> {
                                        deleteCategory.DeleteCategory();
                                    } //Delete Category
                                    case 3 -> {
                                        boolean flag = false;
                                        while (!flag) {
                                            System.out.println("Enter Category ID: ");
                                            int categoryID = input.nextInt();
//                                            System.out.println(categoryID);
                                            category temp = Admin.getCategory(categoryID);
                                            if (temp == null) {
                                                System.out.println("This category doesn't exist! Add the category first or check your input.");
                                                menus.Choice3();
                                                int choice3 = input.nextInt();
//                                                input.nextLine();
//                                                System.out.println(choice3);
                                                switch (choice3) {
                                                    case 1 -> {
                                                        addCategory.AddCategory();
                                                        flag = true;
                                                    }
                                                    case 2 -> {
                                                    }
                                                    case 3 -> {
                                                        flag = true;
                                                    }
                                                    default -> {
                                                        System.out.println("Invalid Choice make sure you enter the choices given!!");
                                                    }
                                                }
                                            } else {
                                                addProduct.AddProduct(temp);
                                                flag = true;
                                            }
                                        }

                                    } //ADD PRODUCT
                                    case 4 -> {
                                        boolean flag = false;
                                        while (!flag) {
                                            System.out.println("Enter Category ID: ");
                                            int categoryID = input.nextInt();
//                                            input.nextLine();
                                            category temp = Admin.getCategory(categoryID);
                                            if (temp == null) {
                                                System.out.println("Such category doesn't exist! check your input.");
                                                menus.Choice4();
                                                int choice4 = input.nextInt();
//                                                input.nextLine();
//                                                System.out.println(choice4);
                                                switch (choice4) {
                                                    case 1 -> {
                                                        continue;
                                                    }
                                                    case 2 -> {
                                                        flag = true;
                                                    }
                                                    default -> {
                                                        System.out.println("Invalid Choice make sure you enter the choices given!!");
                                                    }
                                                }

                                            }
                                            deleteProduct.DeleteProduct(temp);
                                            flag = true;
                                        }
                                    } //delete product
                                    case 5 -> {
                                        setDiscount.SetDiscount();
                                    } //set discount on product
                                    case 6 -> {
                                        addGiveAwayDeals.AddGiveAwayDeal();
                                    } //add giveaway deal
                                    case 7 -> {
                                        input.nextLine();
                                        AdminChoiceFlag = true;
                                    }
                                    default -> {
                                        System.out.println("Invalid Choice make sure you enter the choices given!!");
                                    }

                                }
                                enterFlag = true;
                            }

                        }
                    }
                }
                case 2 -> {
                    exploreProductCatalogue.ProductCatalogue();

                }
                case 3 -> {
                    showAvailableDeals.Show();

                }
                case 4 -> {
                    //TODO: Enter as Customer
                    boolean flag = false;
                    while (!flag) {
                        menus.customerMenu();
                        int choice = input.nextInt();
                        switch (choice) {
                            case 1 -> {
                                customer.signUp();
                            }
                            //todo sign up
                            case 2 -> {
                                customer validCustomer = customer.login();
                                if (validCustomer != null) {
                                    boolean innerFlag = false;
                                    //todo customer menu
                                    while (!innerFlag) {
                                        System.out.println("Welcome " + validCustomer.getUsername() + "!!");
                                        menus.enterCustomer();
                                        int choice1 = input.nextInt();
                                        switch (choice1) {
                                            case 1 -> {
                                                exploreProductCatalogue.ProductCatalogue();
                                            }
                                            //browse material
                                            case 2 -> {
                                                showAvailableDeals.Show();
                                            }
                                            //available deals
                                            case 3 -> {
                                                customer.addProductToCart(validCustomer);
                                            }
                                            //add a product to cart
                                            case 4 -> {
                                                customer.addDealsToCart(validCustomer);
                                            }
                                            //add product deals to cart
                                            case 5 -> {
                                                customer.viewCoupons(validCustomer);
                                            }
                                            //view coupons
                                            case 6 -> {
                                                customer.CheckBalance(validCustomer);
                                            }
                                            //check account balance
                                            case 7 -> {
                                                customer.viewCart(validCustomer);
                                            }
                                            //view cart
                                            case 8 -> {
                                                customer.emptyCart(validCustomer);
                                            }
                                            //todo empty cart
                                            case 9 -> {
                                                customer.checkOut(validCustomer);
                                            }
                                            //todo checkout cart
                                            case 10 -> {
                                                customer.upgradeStatus(validCustomer);
                                            }
                                            //todo upgrade customer status
                                            case 11 -> {
                                                customer.addAmount(validCustomer);
                                            }
                                            //todo add amount to wallet
                                            case 12 -> {
                                                System.out.println("We are sad to see you go :< , return back soon");
                                                innerFlag = true;
                                            }
                                            //back
                                        }
                                    }
                                } else {
                                    System.out.println("The customer doesn't exist! Make sure you have registered or check your username or password");
                                }
                            }
                            //todo login
                            case 3 -> {
                                System.out.println("Logged out successfully");
                                flag = true;
                            }
                        }
                    }
                }
                case 5 -> {
                    welcomeFlag = true;
                    System.out.println("We are sad to see you go :( , we will miss you please return back soon!!");
                }
                default -> {
                    System.out.println("Invalid Choice make sure you enter the choices given!!");
                }
//                    }
//                } catch (Exception e) {System.out.println("Invalid Input!!");welcomeFlag = true;}
            }
        }
    }
}

