package com.nhlstenden.JabberPoint.Accessors;

import com.nhlstenden.JabberPoint.PresentationControls.Presentation;
import com.nhlstenden.JabberPoint.Slides.BitmapItem;
import com.nhlstenden.JabberPoint.Slides.Slide;

/** Een ingebouwde demo-presentatie
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

class DemoPresentation extends Accessor
{

	public void loadFile(Presentation presentation, String fileName)
	{
		presentation.setTitle("Demo Presentation");
		Slide slide;
		slide = new Slide();
		slide.setTitle("JabberPoint");
		slide.appendTextItem(1, "Het Java Presentatie Tool");
		slide.appendTextItem(2, "Copyright (c) 1996-2000: Ian Darwin");
		slide.appendTextItem(2, "Copyright (c) 2000-now:");
		slide.appendTextItem(2, "Gert Florijn en Sylvia Stuurman");
		slide.appendTextItem(4, "JabberPoint aanroepen zonder bestandsnaam");
		slide.appendTextItem(4, "laat deze presentatie zien");
		slide.appendTextItem(1, "Navigeren:");
		slide.appendTextItem(3, "Volgende slide: PgDn of Enter");
		slide.appendTextItem(3, "Vorige slide: PgUp of up-arrow");
		slide.appendTextItem(3, "Stoppen: q or Q");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("Demonstratie van levels en stijlen");
		slide.appendTextItem(1, "Level 1");
		slide.appendTextItem(2, "Level 2");
		slide.appendTextItem(1, "Nogmaals level 1");
		slide.appendTextItem(1, "Level 1 heeft stijl nummer 1");
		slide.appendTextItem(2, "Level 2 heeft stijl nummer 2");
		slide.appendTextItem(3, "Zo ziet level 3 er uit");
		slide.appendTextItem(4, "En dit is level 4");
		presentation.append(slide);

		slide = new Slide();
		slide.setTitle("De derde slide");
		slide.appendTextItem(1, "Om een nieuwe presentatie te openen,");
		slide.appendTextItem(2, "gebruik File->Open uit het menu.");
		slide.appendTextItem(1, " ");
		slide.appendTextItem(1, "Dit is het einde van de presentatie.");
		slide.append(new BitmapItem(1, "JabberPoint.gif"));
		presentation.append(slide);
	}

	public void saveFile(Presentation presentation, String fileName)
	{
		throw new IllegalStateException("Save As->Demo! aangeroepen");
	}
}
