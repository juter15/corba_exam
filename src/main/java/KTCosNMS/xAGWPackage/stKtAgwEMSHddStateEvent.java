package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/stKtAgwEMSHddStateEvent.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../../../src/main/resources/idl/KTCosNMS.idl
* 2022 12 11 Ͽ  6 10 50 KST
*/

public final class stKtAgwEMSHddStateEvent implements org.omg.CORBA.portable.IDLEntity
{
  public short agwEmsType = (short)0;

  // Access Gateway EMS Type
  public String agwEmsId = null;

  // Access Gateway EMS Id
  public String fileSystemName = null;

  // File System Name
  public int totalSize = (int)0;

  // Total Size ( Kbytes )
  public int usedSize = (int)0;

  // Used Size ( Kbytes )
  public int freeSize = (int)0;

  // Free Size ( Kbytes )
  public short usedPercent = (short)0;

  // Used Percent ( % )
  public String date = null;

  public stKtAgwEMSHddStateEvent ()
  {
  } // ctor

  public stKtAgwEMSHddStateEvent (short _agwEmsType, String _agwEmsId, String _fileSystemName, int _totalSize, int _usedSize, int _freeSize, short _usedPercent, String _date)
  {
    agwEmsType = _agwEmsType;
    agwEmsId = _agwEmsId;
    fileSystemName = _fileSystemName;
    totalSize = _totalSize;
    usedSize = _usedSize;
    freeSize = _freeSize;
    usedPercent = _usedPercent;
    date = _date;
  } // ctor

} // class stKtAgwEMSHddStateEvent
