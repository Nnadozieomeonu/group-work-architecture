package com.groupjn.productservice.Builder;

public class CategoryClass {
    //All final attributes
    private final String name; // required
    private final String description; // required

    private CategoryClass(CategoryBuilder ct) {
        this.name = ct.name;
        this.description = ct.description;
    }

    //All getter, and NO setter to provde immutability
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public static class CategoryBuilder
    {
        private final String name;
        private String description;

        public CategoryBuilder(String name) {
            this.name = name;
        }
        public CategoryBuilder description(String description) {
            this.description = description;
            return this;
        }
        //Return the finally consrcuted User object
        public CategoryClass build() {
            CategoryClass cat =  new CategoryClass(this);
            return cat;
        }
        private void validateUserObject(CategoryClass user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
