package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/DiskInfoSt.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
*/

public final class DiskInfoSt implements org.omg.CORBA.portable.IDLEntity
{
  public String diskPath = null;

  public int diskUsage = (int)0;

  public DiskInfoSt ()
  {
  } // ctor

  public DiskInfoSt (String _diskPath, int _diskUsage)
  {
    diskPath = _diskPath;
    diskUsage = _diskUsage;
  } // ctor

} // class DiskInfoSt