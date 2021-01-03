package application;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class DataBase implements Serializable  {

private static final long serialVersionUID=42L;
private static  DataBase d=null;
private Score savedscore;
private ArrayList<DataTable> databaseFiles;

public static DataBase getinstance()
{
if(d==null)
{
d=new DataBase();
d.setDatabaseFiles(new ArrayList<>());
d.setSavedscore(new Score(0,0,new int[5]));
}
return d;
}

private DataBase()
{
// databaseFiles=new ArrayList<>();
// savedscore=new Score(0,0,new int[5]);

}

public void addData(DataTable d)
{
databaseFiles.add(d);
}

public void removeData(DataTable d)
{
if(databaseFiles.contains(d))
{
databaseFiles.remove(d);
}
}

public void deletAllProgress()
{
setD(new DataBase());
}

public ArrayList<DataTable> getDatabaseFiles()
{
return databaseFiles;
}

public void setDatabaseFiles(ArrayList<DataTable> arr)
{
databaseFiles=arr;
}

public Score getSavedscore() {
if(savedscore==null)
{
savedscore=new Score (0,0,new int[5]);
}
return savedscore;
}

public  void setSavedscore(Score savedscore) {
this.savedscore = savedscore;
}

public static void saveStars()
{

try
{
Main.serialize();
}
catch(IOException e)
{
System.out.println("Can't close stream");
}
}

public DataBase getD() {
return d;
}

public void setD(DataBase d) {
     this.d = d;
}

public Iterator creatIterator()
{
return new DataTableIterator(databaseFiles);
}


}