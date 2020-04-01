package lib;

class Types {
    private String type;

    public String getType() {
        return type;
    }

    class Data extends Types{
        private final Target dataTarget;
        private String data;
        public Data (Target t, String d){
            type = "Data"; 
            dataTarget = t;
            data = d;
        }
        public Target getTarget(){
            return dataTarget;
        }
        public String getData(){
            return data;
        }
        
    }
    class Target extends Types{
        private int id;
        private String targetName;
        public Target(int i, String t){
            type = "Target";
            id = i;
            targetName=t;
        }
        public int getID(){
            return id;
        }
        public String getTargetName(){
            return targetName;
        }
    }
    class Menu {
        public boolean isON;
        public Menu() {
            isON = false;
            type = "Menu";
        }
    }
}