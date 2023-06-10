import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientFTP {
    public static Socket soc;
    public static DataInputStream din = null;
    public static DataOutputStream dout = null;
    public static DataInputStream datadin = null;
    public static DataOutputStream dataout = null;
    public static Socket datasoc;
    public static int PortNo,dataPort;

    public static String Host;
    public String[] connect(String args[]) throws Exception{
        String userName="";
        String password="";
        String msg="Fail";
        if(args.length ==4){
            Host = args[0];
            PortNo = Integer.parseInt(args[1]);
            userName=args[2];
            password = args[3];
        }
        else{
            System.out.println("Error");
        }

        soc=new Socket(Host,PortNo);
        dataPort=PortNo-1;

        System.out.println(soc.getPort());
        din=new DataInputStream(soc.getInputStream());
        dout=new DataOutputStream(soc.getOutputStream());

        dout.writeUTF(userName);
        dout.writeUTF(password);

        String check= din.readUTF();
        String role= din.readUTF();
        String[] login={check,role};
        return login;
    }
    public String getPWD() throws Exception{

        dout.writeUTF("PWD");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        System.out.println("before read in pwd");
        String pwd=datadin.readUTF();
        System.out.println("getpwd");
        return pwd;
    }

    public ArrayList<String> getFiles() throws IOException{

        ArrayList<String> fileList = new ArrayList<String>();
        dout.writeUTF("getFiles");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        int length=din.readInt();
        for (int i=0; i < length; i++){
            fileList.add(din.readUTF());
        }
        System.out.println("in get files");

        return fileList;
    }

    public void Dis(){

    }

    public ArrayList<String> getList() throws IOException{

        ArrayList<String> fileList = new ArrayList<String>();
        dout.writeUTF("getList");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        System.out.println("Testin list");
        int length=Integer.parseInt(din.readUTF());
        for (int i=0; i < length; i++){
            String check =din.readUTF();
            if(check.compareTo("1")==0)
            {
                String nameFile =din.readUTF();
                String lengthFile =din.readUTF();
                int lenName = nameFile.length();
                String kb="byte";
                int Length = Integer.parseInt(lengthFile);
                if(Length>1024)
                {
                    Length /=1024;
                    kb="kb";
                }
                String format=String.format("%"+(lenName-80)+"s%s","--File: "+nameFile,"Size: "+Length+kb);
                System.out.println(format);
                fileList.add(format);
            }
            else{
                String format=String.format("%-70s",din.readUTF());
                fileList.add(format);
            }

        }

        return fileList;
    }

    public void disconnect() throws IOException{

        dout.writeUTF("DISCONNECT");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        dout.flush();
        soc.close();

    }
    public void deleteFile(String filename) throws IOException{

        dout.writeUTF("Delete");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        dout.writeUTF(filename);

    }
    public String setCD(String path) throws IOException {

        dout.writeUTF("CD");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        dout.writeUTF(path);
        String status=din.readUTF();
        return status;

    }
    public String setNewDir(String dir) throws IOException{

        dout.writeUTF("mkdir");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        dout.writeUTF(dir);
        String status=din.readUTF();
        return status;
    }
    public ArrayList<String> getDir() throws IOException{

        ArrayList<String> fileList = new ArrayList<String>();
        dout.writeUTF("getDir");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        int length=din.readInt();
        for (int i=0; i < length; i++){
            fileList.add(din.readUTF());
        }
        //System.out.println("in get files");

        return fileList;
    }
    public String deleteFolder(String dirName) throws IOException{

        dout.writeUTF("rmdir");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        dout.writeUTF(dirName);
        String status=din.readUTF();
        return status;
    }

    int countDir=0;
    int countFile=0;
    public String deleteAllinFolder(String dirName,String check) throws IOException{

        dout.writeUTF("rmdirAll");
        datasoc=new Socket(Host,dataPort);
        datadin=new DataInputStream(datasoc.getInputStream());
        dataout=new DataOutputStream(datasoc.getOutputStream());
        dout.writeUTF(dirName);
        countDir= Integer.parseInt(din.readUTF());
        returnDir();
        countFile= Integer.parseInt(din.readUTF());
        returnFile();
        dout.writeUTF(check);
        String status=din.readUTF();
        return status;
    }

    public int returnDir() {
        return countDir;
    }
    public int returnFile() {
        return countFile;
    }
}
