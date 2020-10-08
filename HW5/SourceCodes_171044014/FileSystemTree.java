import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The FileSystemTree Class
 */
public class FileSystemTree implements myFileSystem {
    /**
     * The Root.
     */
    protected FileNode root;

    /**
     * Instantiates a new File system tree.
     *
     * @param dir the dir
     */
    public FileSystemTree(String dir){
        root = new FileNode(dir);
        root.isDir = true;
    }

    /**
     * The FileNode class
     */
    protected static class FileNode{
        /**
         * The Data.
         */
        protected String data;
        /**
         * The Parent.
         */
        protected FileNode parent = null;
        /**
         * The Children.
         */
        protected List<FileNode> children = new ArrayList<>();
        /**
         * The Is file.
         */
        protected boolean isFile = false;
        /**
         * The Is dir.
         */
        protected boolean isDir = false;
        /**
         * The Is searched.
         */
        protected boolean isSearched = false;

        /**
         * Instantiates a new File node.
         *
         * @param data the data
         */
        public FileNode(String data){
            this.data = data;
        }

        public String toString(){
            return data;
        }

        /**
         * Get data string.
         *
         * @return the string
         */
        protected String getData(){ return data; }

        /**
         * Get children number int.
         *
         * @return the int
         */
        protected int getChildrenNumber(){ return children.size(); }

        /**
         * Is leaf boolean.
         *
         * @return the boolean
         */
        public boolean isLeaf(){ return children.size() == 0; }

        private FileNode returnsFirstNotSearchedChildren(){
            for(int i=0;i<children.size();++i){
                if(!children.get(i).isSearched)
                    return children.get(i);
            }
            return null;
        }

        private void setIsSearchedFalse(){
            for(int i=0;i<children.size();++i){
                children.get(i).isSearched = false;
            }
        }
    }

    public void addDir(String directory){
        String[] arr = directory.split("/");
        FileNode temp = root;
        addDir(arr,temp,0,0);
    }

    private void addDir(String[] arr,FileNode t,int index,int childrenNum){
        if(index+1 == arr.length-1 && t.isDir){
            FileNode temp = new FileNode(arr[arr.length-1]);
            temp.parent = t;
            temp.isDir = true;
            for(int i=0;i<t.children.size();++i){
                if(t.children.get(i).data.equals(temp.data)){
                    System.out.println("This directory could not be added because there is a file or directory with the same name.");
                    return;
                }
            }
            t.children.add(temp);
            return;
        }
        if(arr[index].equals(t.getData()) && t.getChildrenNumber() > childrenNum && t.isDir){
            if(arr[index+1].equals(t.children.get(childrenNum).getData())){
                t = t.children.get(childrenNum);
                addDir(arr,t,index+1,0);
            } else{
                addDir(arr,t,index,childrenNum+1);
            }
        }
    }

    public void addFile(String file){
        String[] arr = file.split("/");
        FileNode temp = root;
        addFile(arr,temp,0,0);
    }

    private void addFile(String[] arr,FileNode t,int index,int childrenNum){
        if(index+1 == arr.length-1 && t.isDir){
            FileNode temp = new FileNode(arr[arr.length-1]);
            temp.parent = t;
            temp.isFile = true;
            for(int i=0;i<t.children.size();++i){
                if(t.children.get(i).data.equals(temp.data)){
                    System.out.println("This file could not be added because there is a file or directory with the same name.");
                    return;
                }
            }
            t.children.add(temp);
            return;
        }
        if(arr[index].equals(t.getData()) && t.getChildrenNumber() > childrenNum && t.isDir){
            if(arr[index+1].equals(t.children.get(childrenNum).getData())){
                t = t.children.get(childrenNum);
                addFile(arr,t,index+1,0);
            } else{
                addFile(arr,t,index,childrenNum+1);
            }
        }
    }

    public void remove(String document){
        String[] arr = document.split("/");
        if(arr.length == 1 && document.equals(root.data)){
            System.out.println("You cannot delete root folder!");
            return;
        }
        FileNode temp = root;
        remove(arr,temp,0,0);
    }

    private void remove(String[] arr,FileNode t,int index,int childrenNum){
        if(index+1 == arr.length-1){
            if(!t.children.get(childrenNum).isLeaf()){
                String choose;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Are you sure? If you delete this folder, the contents of this folder will be deleted.(Y/N)");
                choose = scanner.next();

                if(choose.equals("Y") || choose.equals("y")){
                    t.children.remove(childrenNum);
                    return;
                } else{
                    return;
                }
            }
            t.children.remove(childrenNum);
            return;
        }
        if(arr[index].equals(t.getData()) && t.getChildrenNumber() > childrenNum){
            if(arr[index+1].equals(t.children.get(childrenNum).getData())){
                t = t.children.get(childrenNum);
                remove(arr,t,index+1,0);
            } else{
                remove(arr,t,index,childrenNum+1);
            }
        }
    }

    public void search(String element){
        FileNode temp = root;
        search(element,temp);
    }

    private void search(String element,FileNode node){
        /*System.out.print("1-");
        System.out.print(node +" - ");*/
        FileNode child = node.returnsFirstNotSearchedChildren();
        //System.out.println(child);
        if(child == null && node == root){
            root.isSearched = false;
            root.setIsSearchedFalse();
            return;
        }
        else if(child == null){
            node.setIsSearchedFalse();
            node = node.parent;
            search(element,node);
        }
        else {
            child.isSearched = true;
            if (child.data.contains(element)) {
                printNode(child, child.isDir);
                System.out.print("\n");
            }
            if(child.isLeaf()){
                search(element,child.parent);
            } else{
                node = child;
                search(element,node);
            }
        }
    }

    private void printNode(FileNode node,boolean isDir){
        if(node == null)
            return;
        if(node == root){
            if(isDir)
                System.out.print("dir - ");
            else
                System.out.print("file - ");
        }
        printNode(node.parent,isDir);
        if(!node.isLeaf())
            System.out.print(node.data + "/");
        else
            System.out.print(node.data);
    }

    public void printFileSystem(){
        FileNode temp = root;
        System.out.println("The root file - " +  root);
        printFileSystem(temp);
    }

    private void printFileSystem(FileNode node){
        FileNode child = node.returnsFirstNotSearchedChildren();
        //System.out.println(child);
        if(child == null && node == root){
            root.isSearched = false;
            root.setIsSearchedFalse();
            return;
        }
        else if(child == null){
            node.setIsSearchedFalse();
            node = node.parent;
            printFileSystem(node);
        }
        else {
            if(!child.isSearched){
                printNode(child,child.isDir);
                System.out.println();
            }
            child.isSearched = true;
            if(child.isLeaf()){
                printFileSystem(child.parent);
            } else{
                node = child;
                printFileSystem(node);
            }
        }
    }
}
