package corba.CorbaConterollerInterfacePackage;


/**
* TicTakTicket/corba/CorbaConterollerInterfacePackage/bestellungListHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from TicTakTicket.idl
* Mittwoch, 20. November 2013 20:15 Uhr MEZ
*/

public final class bestellungListHolder implements org.omg.CORBA.portable.Streamable
{
  public corba.StructKarteBestellen value[] = null;

  public bestellungListHolder ()
  {
  }

  public bestellungListHolder (corba.StructKarteBestellen[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corba.CorbaConterollerInterfacePackage.bestellungListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corba.CorbaConterollerInterfacePackage.bestellungListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corba.CorbaConterollerInterfacePackage.bestellungListHelper.type ();
  }

}
