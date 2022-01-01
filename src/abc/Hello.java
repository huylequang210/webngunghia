
package abc;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.vocabulary.DC;
import org.apache.jena.vocabulary.VCARD;

public class Hello {

	public Hello() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		// create an empty Model
		Model person = ModelFactory.createDefaultModel();
		Model covid = ModelFactory.createDefaultModel();
		
		//Resource personResource = person.createResource();
		
		// add the property
		person
			.createResource().addProperty(DC.creator,
					person.createResource()
						.addProperty(VCARD.N, "Nguyễn Văn A")
						.addProperty(VCARD.ADR, "40 Lê Lợi, Huế")
						.addProperty(VCARD.BDAY, "02/11/1977"))
			.addProperty(DC.subject, 
					person.createResource()
						.addProperty(DC.date, "30/12/2021")
						.addProperty(DC.identifier, "1")
						.addProperty(DC.source, "F1"));
		
		covid.createResource()
			.addProperty(DC.description, "covid")        
			.addProperty(DC.identifier, "1")
			.addProperty(DC.title, "omicron");
		
		StmtIterator iter = person.listStatements();
		
		while (iter.hasNext()) {
			Statement stmt      = iter.nextStatement();  // get next statement
		    Resource  subject   = stmt.getSubject();     // get the subject
		    Property  predicate = stmt.getPredicate();   // get the predicate
		    RDFNode   object    = stmt.getObject();      // get the object
		    
		    System.out.print(subject.toString());
		    System.out.print(" " + predicate.toString() + " ");
		    if (object instanceof Resource) {
		       System.out.print(object.toString());
		    } else {
		        // object is a literal
		        System.out.print(" \"" + object.toString() + "\"");
		    }

		    System.out.println(" .");
		}
		
		StmtIterator iter2 = covid.listStatements();
		while (iter2.hasNext()) {
			Statement stmt      = iter2.nextStatement();  // get next statement
		    Resource  subject   = stmt.getSubject();     // get the subject
		    Property  predicate = stmt.getPredicate();   // get the predicate
		    RDFNode   object    = stmt.getObject();      // get the object
		    
		    System.out.print(subject.toString());
		    System.out.print(" " + predicate.toString() + " ");
		    if (object instanceof Resource) {
		       System.out.print(object.toString());
		    } else {
		        // object is a literal
		        System.out.print(" \"" + object.toString() + "\"");
		    }

		    System.out.println(" .");
		}
		
		
	}

}
