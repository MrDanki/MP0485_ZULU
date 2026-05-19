package model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

/**
 * Encapsulated class that defines the type of entity that will manage the application.
 * @author Fran Perez
 * @version 1.1.0
 */

@Entity
public class Person implements Serializable{

    @Id 
    private String NIF;
    private String NAME;
    private Date DATE_OF_BIRTH;
    private String PHONE_NUMBER;
    private String EMAIL;
    private String POSTAL_CODE;
    @Transient
    private ImageIcon PHOTO;
    @Lob
    private byte[] PHOTO_ONLY_JPA;

    public Person(){
  
    }
    
    /**
     * Constructor to validate new person. Two persons cannot have the same NIF
     * @param nif 
     */
    public Person(String nif){
        this.NIF = nif;
    }
    
    /**
     * Constructor with mandatory data.
     * @author Fran Perez
     * @version 1.0
     * @param nif
     * @param name
     */
    public Person(String nif,String name){
        this.NIF = nif;
        this.NAME = name;
     
    }
    
    /**
     * Constructor with minimal data.
     * @author Daniel Lop
     * @version 1.0
     * @param nif
     * @param name
     * @param dateOfBirth
     * @param photo
     */
    public Person(String name,String nif,Date dateOfBirth,ImageIcon photo){
        this.NAME = name;      
        this.NIF = nif;
        this.DATE_OF_BIRTH = dateOfBirth;
        this.PHOTO = photo;
    }

    /**
     * Constructor with all data
     * @author Fran Perez
     * @version 1.0
     * @param name
     * @param nif
     * @param dateOfBirth
     * @param photo
     * @param phoneNumber
     * @param email
     * @param postalCode
     */
    public Person(
            String name,
            String nif,
            Date dateOfBirth,
            ImageIcon photo,
            String phoneNumber,
            String email,
            String postalCode     
    ){
        this.NAME = name;      
        this.NIF = nif;
        this.DATE_OF_BIRTH = dateOfBirth;
        this.PHOTO = photo;
        this.PHONE_NUMBER = phoneNumber;
        this.EMAIL = email;
        this.POSTAL_CODE = postalCode;
    }

    // GETTERS
    public String getNif(){return NIF;}
    public String getName(){return NAME; }
    public Date getDateOfBirth(){return DATE_OF_BIRTH;}
    public String getPhoneNumber(){return PHONE_NUMBER;}
    public String getEmail(){return EMAIL;}
    public String getPostalCode(){return POSTAL_CODE;}
    public ImageIcon getPhoto(){return PHOTO;}
    public byte[] getPhotoOnlyJPA(){return PHOTO_ONLY_JPA;}
    
    // SETTERS
    public void setNif(String nif){this.NIF = nif;}
    public void setName(String name){this.NAME = name;}
    public void setDateOfBirth(Date dateOfBirth){this.DATE_OF_BIRTH = dateOfBirth;}
    public void setPhoneNumber(String phoneNumber){this.PHONE_NUMBER = phoneNumber;}
    public void setEmail(String email){this.EMAIL = email;}
    public void setPostalCode(String postalCode){this.POSTAL_CODE = postalCode;}
    public void setPhoto(ImageIcon photo){this.PHOTO = photo;}
    public void setPhotoOnlyJPA(byte[] photoOnlyJPA){this.PHOTO_ONLY_JPA = photoOnlyJPA;}
        
    /**
     * Function used to compare two Personas. There cannot be two or more people
     * with the same ID. Actually it isn't used in this project.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.NIF);
        return hash;
    }

    /**
     * Function used to compare two Personas in ArrayList and HashMap 
     * structures. There cannot be two or more people with the same ID.
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.hashCode(), other.hashCode());
    }
 
    /**
     * Function sed to show person's inform by console. Only for debugging 
     * pourposes.
     * @return 
     */
    @Override
    public String toString() {
        return "Person {" +
               "NIF='" + NIF + '\'' +
               ", NAME='" + NAME + '\'' +
               ", DATE_OF_BIRTH=" + (DATE_OF_BIRTH != null ? DATE_OF_BIRTH : "null") +
               ", PHONE_NUMBER='" + PHONE_NUMBER + '\'' +
               ", EMAIL='" + EMAIL + '\'' +
               ", POSTAL_CODE='" + POSTAL_CODE + '\'' +
               ", PHOTO=" + (PHOTO != null) +
               ", PHOTO_ONLY_JPA=" + (PHOTO_ONLY_JPA != null ? PHOTO_ONLY_JPA.length + " bytes" : "null") +
               '}';
    }
    
    /**
     * Function to convert to CSV.
     * @return 
     */
    public String toCSV() {
        return 
            NIF+","+
            NAME+","+
            (DATE_OF_BIRTH != null ? DATE_OF_BIRTH.getTime() : "null")+","+
            PHONE_NUMBER+","+
            EMAIL+","+
            POSTAL_CODE+","+
            (PHOTO != null)+","+
            (PHOTO_ONLY_JPA != null ? PHOTO_ONLY_JPA.length : 0);
    }

}
