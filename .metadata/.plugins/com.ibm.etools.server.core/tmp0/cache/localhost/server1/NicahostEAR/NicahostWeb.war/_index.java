package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _index extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _index( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/index.jsp";

  public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    /* Init Method Phase */
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    String  _value = null;
    java.util.Stack _jspxTagObjects = new java.util.Stack();
    /* Service Declaration Phase */
      /* ------  html:html ------ */
      org.apache.struts.taglib.html.HtmlTag _jspx_th_html_html_0 = new org.apache.struts.taglib.html.HtmlTag();

      try {

        if (_jspx_inited == false) {
          synchronized (this) {
            if (_jspx_inited == false) {
              _jspx_init();
              _jspx_inited = true;
            }
          }
        }

        _jspxFactory = JspFactory.getDefaultFactory();
        response.setContentType("text/html; charset=UTF-8");
        pageContext = _jspxFactory.getPageContext(this, request, response,
        			"", true, 8192, true);

        application = pageContext.getServletContext();
        config = pageContext.getServletConfig();
        session = pageContext.getSession();
        out = pageContext.getOut();

        /* Service Method Phase */

        // HTML // begin [file="/index.jsp";from=(0,0);to=(2,0)]
          out.write("\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");

        // end
        // HTML // begin [file="/index.jsp";from=(2,58);to=(3,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/index.jsp";from=(3,58);to=(4,0)]
          out.write("\r\n");

        // end
        // ##DEBUG## ##TAGLIB## "/index.jsp" 5,0-"/index.jsp" 5,11  LineMapIndex:1
          _jspx_th_html_html_0.setPageContext(pageContext);
          _jspx_th_html_html_0.setParent(null);
          _jspxTagObjects.push(_jspx_th_html_html_0);
            int _jspx_eval_html_html_0 = _jspx_th_html_html_0.doStartTag();
            if (_jspx_eval_html_html_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
              // end
              // HTML // begin [file="/index.jsp";from=(4,11);to=(6,0)]
                out.write("\r\n<HEAD>\r\n");

              // end
              // HTML // begin [file="/index.jsp";from=(10,2);to=(67,0)]
                out.write("\r\n<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n<META name=\"GENERATOR\" content=\"IBM WebSphere Studio\">\r\n<TITLE>Web Applications</TITLE>\r\n<LINK rel=\"stylesheet\" href=\"css/ebacStyle.css\" type=\"text/css\">\r\n</HEAD>\r\n\r\n<BODY>\r\n<h1>nicahost.com</h1>\r\n\r\n<TABLE border=\"0\" align=\"center\" id=\"sessionTable\">\r\n\t<TBODY>\r\n\t\t<TR>\r\n\t\t\t<TD>Nos encargamos de poner su negocio en línea usando las tecnologías modernas de desarrollo empresarial. No importa el tipo de negocio que posea. Desarrollamos con tecnologías J2EE de Java lo que nos permite integrarnos a su ya existen sistema actual.<BR>&nbsp;\r\n\t\t\t</TD>\r\n\t\t\t<TD></TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TH style=\"text-align: left\"><A href=\"/NicahostWeb/toModule.do?prefix=/hotelreserve&amp;page=/reserve.do\">Hotel\r\n\t\t\tReserve*</A></TH>\r\n\t\t\t<TD></TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD>Reservaciones en línea para hoteles. Es una aplicación que permite buscar por disponibilidades de cuartos y reservar anticipadamente. Las reservas se hacen debitando de una tarjeta de crédito del cliente. Entre algunas de las características están:<UL>\r\n\t\t\t\t<LI>Multi lenguaje</LI>\r\n\t\t\t\t<LI>Envio de notificación por correo</LI>\r\n\t\t\t\t<LI>Webchat para asistencia técnica</LI>\r\n\t\t\t\t<LI>Módulo de administración de la aplicacion vía web</LI>\r\n\t\t\t\t<LI>Cancelación de reservaciones</LI>\r\n\t\t\t</UL>\r\n\t\t\t<A href=\"/NicahostWeb/toModule.do?prefix=/hotelreserve&amp;page=/reserve.do\">Ver demo</a><p>&nbsp;</p>\r\n\t\t\t</TD>\r\n\t\t<TD>\r\n\t\t\t</TD></TR>\r\n\t\t<TR>\r\n\t\t\t<TH style=\"text-align: left\"><A href=\"/NicahostWeb/toModule.do?prefix=/clasificados&amp;page=/default.do\">Carrito de compra*</A></TH>\r\n\t\t\t<TD></TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD>Implementación de carrito de comprar para ventas en línea. Ideal para vender productos en línea de cualquier tipo.\r\n\t\t\t<UL>\r\n\t\t\t\t<LI>Servicio de búsqueda de artículos por palabras claves o categorías</LI>\r\n\t\t\t\t<LI>Compras rápidas una vez se haya registrado el cliente</LI>\r\n\t\t\t\t<LI>Multi lenguje</LI>\r\n\t\t\t</UL>\r\n\t\t\t\t<A href=\"/NicahostWeb/toModule.do?prefix=/clasificados&amp;page=/default.do\">Ver demo</a><p>&nbsp;</p>\t\t\t\r\n\t\t\t</TD>\r\n\t\t<TD>\r\n\t\t\t</TD></TR>\r\n\t\t<TR>\r\n\t\t\t<TD></TD>\r\n\t\t\t<TD></TD>\r\n\t\t</TR>\r\n\t</TBODY>\r\n</TABLE>\r\n<P></P>\r\n</BODY>\r\n");

              // end
              // ##DEBUG## "/index.jsp" 68,0-"/index.jsp" 68,12  LineMapIndex:2
              } while (_jspx_th_html_html_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (_jspx_th_html_html_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
        // end
        // HTML // begin [file="/index.jsp";from=(67,12);to=(68,0)]
          out.write("\r\n");

        // end

      } catch (Throwable t) {
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (pageContext != null) pageContext.handlePageException(t);
      } finally {
        while (_jspxTagObjects.empty() == false){
          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
        }
        if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);

        /* Service Finally Phase */
      }
    }
    public static String[][] _jspx_debug_FileMapping = {
    {
    "/index.jsp", 
    },
    {
    "0", 
    },
    };
    public static String[][] _jspx_debug_LineMapping = {
    {
    "0", 
    "0", 
    "0", 
    },
    {
    "1", 
    "5", 
    "68", 
    },
    };
  }
