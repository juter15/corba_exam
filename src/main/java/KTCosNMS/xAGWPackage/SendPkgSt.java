package KTCosNMS.xAGWPackage;


/**
* KTCosNMS/xAGWPackage/SendPkgSt.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../corba_test/BcNNMS_AGW.idl
*/

public final class SendPkgSt implements org.omg.CORBA.portable.IDLEntity
{
  public String adaptorIp = null;
  public String userId = null;
  public String password = null;
  public String swVersion = null;
  public String pkgName = null;
  public int pkgSize = (int)0;
  public String time = null;
  public String pkgDir = null;

  public SendPkgSt ()
  {
  } // ctor

  public SendPkgSt (String _adaptorIp, String _userId, String _password, String _swVersion, String _pkgName, int _pkgSize, String _time, String _pkgDir)
  {
    adaptorIp = _adaptorIp;
    userId = _userId;
    password = _password;
    swVersion = _swVersion;
    pkgName = _pkgName;
    pkgSize = _pkgSize;
    time = _time;
    pkgDir = _pkgDir;
  } // ctor

} // class SendPkgSt