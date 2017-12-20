/*
 * Created on Jul 19, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.admin.dao;

import java.awt.Color;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.nicahost.common.config.bean.GlobalParametersBean;
import com.nicahost.common.config.bean.InitParameterMapBean;
import com.nicahost.common.dao.DBBaseDAO;
import com.nicahost.common.util.IPathConverter;
import com.nicahost.common.util.PathConverter;

/**
 * @author rgbetanco
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CreatePDFAnulledNote extends DBBaseDAO {
	private Document doc = new Document();
	private PdfWriter writer;

	private static final String DBASEKEY = "dsHotel";
	private static final String RESERVATION_SQL =
		//   1		  2			3				4				5			6
	"SELECT a.id, a.roomid, a.email, a.reservationdate, a.checkindate, a.checkoutdate, "
		+ 
		//   7		  8			  9			
	"a.total, b.firstname, b.lastname, a.confirmationCode FROM roomreservation a, clientes b"
		+ " WHERE a.id = ? and a.email = b.email";

	private int idLocal = 0;
	
	/**
	 * Inicializacion estatica para encontrar la ruta del directorio de archivos temporales
	 * 
	 * @author Henry Jiron
	 */
	private static String TEMPFILE_PATH = "";	
	static {
		InitParameterMapBean param = GlobalParametersBean.getInstance().getList();
		String path = param.getValue(GlobalParametersBean.TEMPFILES);
		IPathConverter pathConverter = new PathConverter();		
		TEMPFILE_PATH = pathConverter.getAbsolutePath(path);		
	}
		

	public CreatePDFAnulledNote(int idParm) {
		this.idLocal = idParm;

	}

	public void CreateFile() throws Exception {
		addHeaderEnglish();
		addDetailEnglish();
	}
	public void addHeaderEnglish() throws Exception {
		try {
			writer =
				PdfWriter.getInstance(
					doc,
					new FileOutputStream(TEMPFILE_PATH + idLocal + ".pdf"));
			doc.open();

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		Date today = new Date();
		SimpleDateFormat day = new SimpleDateFormat("dd");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		try {

			Paragraph p0 =
				new Paragraph(
					new Chunk(
						"Confirmation Date: "
							+ day.format(today)
							+ "/"
							+ month.format(today)
							+ "/"
							+ year.format(today),
						FontFactory.getFont(FontFactory.HELVETICA, 10)));

			Phrase ph1 = new Phrase("Hotel Villa Paraiso", FontFactory.getFont(FontFactory.COURIER_BOLD, 14, Font.NORMAL, new Color(0, 128, 0)));
			
			Paragraph p1 = new Paragraph(ph1);
			p1.setAlignment(1);

			Phrase ph2 = new Phrase("Anullment Note", FontFactory.getFont(FontFactory.COURIER_BOLD, 14, Font.NORMAL, new Color(0, 128, 0)));

			Paragraph p2 = new Paragraph(ph2);
					
			p2.setAlignment(1);

			Paragraph p3 =
				new Paragraph(
					new Chunk(
						"______________________________________________________________",
						FontFactory.getFont(FontFactory.COURIER_BOLD, 14)));
			p3.setAlignment(1);
			doc.add(Chunk.NEWLINE);

			Paragraph p4 =
				new Paragraph(
					new Chunk(
						"Id"
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ "RoomNum"
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ "Res. Date"
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ "In Date"
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ "Out Date"
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ "Total"
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t'
							+ '\t',
						FontFactory.getFont(FontFactory.COURIER_BOLD, 12)));
			doc.add(Chunk.NEWLINE);

			doc.add(p0);
			doc.add(p1);
			doc.add(p2);
			doc.add(p3);
			doc.add(p4);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
	public void addDetailEnglish() throws Exception {

		Connection con = null;

		PreparedStatement stm = null;

		ResultSet rs = null;

		con = getPooledConnection(DBASEKEY);

		try {
			stm = con.prepareStatement(RESERVATION_SQL);

			stm.setInt(1, this.idLocal);

			rs = stm.executeQuery();

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			int num = 0;
			Paragraph p5 = null;
			Paragraph p6 = null;
			Paragraph p7 = null;
			while (rs.next()) {

				p5 =
					new Paragraph(
						new Chunk(
							""
								+ rs.getInt(1)
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ rs.getInt(2)
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ df.format(new Date(rs.getLong(4)))
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ df.format(new Date(rs.getLong(5)))
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ df.format(new Date(rs.getLong(6)))
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ '\t'
								+ rs.getDouble(7),
							FontFactory.getFont(FontFactory.TIMES_ROMAN, 14)));

				p6 =
					new Paragraph(
						new Chunk(
							""
								+ "______________________________________________________________",
							FontFactory.getFont(FontFactory.COURIER, 14)));

				p7 =
					new Paragraph(
						new Chunk(
							"Client email: "
								+ rs.getString(3)
								+ '\n'
								+ "Reservation made by: "
								+ rs.getString(8)
								+ " "
								+ rs.getString(9)
								+ '\n'
								+ "Confirmation Code: "
								+ rs.getString(10)
								+ '\n'
								,
							FontFactory.getFont(
								FontFactory.HELVETICA_BOLD,
								12)));

				num++;

			}
			Chunk c7 = new Chunk(
							"                                                                       "
								+ "                                                                 "
								+ "                                                                 "
								+ "                                                                 ",
							FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
					c7.setUnderline(new Color(0x33, 0x66, 0x00), 0.0f, 0.3f, 0.0f, 0.4f, PdfContentByte.LINE_CAP_ROUND);
			doc.add(p5);
			doc.add(p6);
			doc.add(Chunk.NEWLINE);
			doc.add(p7);
			doc.add(c7);

		} catch (Exception e) {
			System.out.println("Error aqui: " + e.getMessage());
		} finally {
			closeConnection(rs, stm, con);
		}

		Paragraph p8 =
			new Paragraph(
				new Chunk(
					"We are sorry: your reservation could not be process "
						+ "at this time.",
					FontFactory.getFont(FontFactory.COURIER_BOLD, 12)));

		p8.indentationRight();
		p8.setAlignment(Element.ALIGN_JUSTIFIED);
		
		Chunk c9 = new Chunk("Lo sentimos mucho: su reservacion no pudo ser procesada "
		+ "por el hotel en esto momentos.",
		FontFactory.getFont(FontFactory.COURIER_BOLD, 12));
		c9.setBackground(new Color(0xFF, 0xDE, 0xAD));
		
		Paragraph p9 =
			new Paragraph(c9);

		p9.indentationRight();
		p9.setAlignment(Element.ALIGN_JUSTIFIED);

		doc.add(p8);
		Chunk c = new Chunk(
				"                                                                       "
					+ "                                                                 "
					+ "                                                                 "
					+ "                                                                 ",
				FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
		c.setUnderline(new Color(0x33, 0x66, 0x00), 0.0f, 0.3f, 0.0f, 0.4f, PdfContentByte.LINE_CAP_ROUND);
		
		doc.add(c);
				
		doc.add(p9);
		
		//Chunk ph9 = new Chunk("to Cancel Reservation; Para Cancelar la reservacion", FontFactory.getFont(FontFactory.HELVETICA, 9, Font.UNDERLINE, new Color(0, 0, 255))).setAnchor(new URL("http://127.0.0.1:9080/hotelreserve/cancelReservation.do"));
		//doc.add(ph9);
		
		doc.close();

	}
}
