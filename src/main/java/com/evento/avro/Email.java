/**
 * Autogenerated by Avro
 * <p>
 * DO NOT EDIT DIRECTLY
 */
package com.evento.avro;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Email extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Email\",\"namespace\":\"com.webtrekk.email.service.avro\",\"fields\":[{\"name\":\"from\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"From email address\"},{\"name\":\"to\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"To email address\"},{\"name\":\"cc\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Cc email address\"},{\"name\":\"bcc\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Bcc email address\"},{\"name\":\"subject\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Email subject\"},{\"name\":\"body\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Email body\"},{\"name\":\"attachments\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Attachment\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Attachment name\"},{\"name\":\"attachmentURI\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Attachment url\"}]}},\"default\":[]}],\"version\":\"1\"}");
    private static final long serialVersionUID = 2738582646341466352L;
    private static SpecificData MODEL$ = new SpecificData();
    private static final BinaryMessageEncoder<Email> ENCODER =
            new BinaryMessageEncoder<Email>(MODEL$, SCHEMA$);
    private static final BinaryMessageDecoder<Email> DECODER =
            new BinaryMessageDecoder<Email>(MODEL$, SCHEMA$);
    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<Email>
            WRITER$ = (org.apache.avro.io.DatumWriter<Email>) MODEL$.createDatumWriter(SCHEMA$);
    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<Email>
            READER$ = (org.apache.avro.io.DatumReader<Email>) MODEL$.createDatumReader(SCHEMA$);
    /** From email address */
    @Deprecated
    public java.lang.String from;
    /** To email address */
    @Deprecated
    public java.lang.String to;
    /** Cc email address */
    @Deprecated
    public java.lang.String cc;
    /** Bcc email address */
    @Deprecated
    public java.lang.String bcc;
    /** Email subject */
    @Deprecated
    public java.lang.String subject;
    /** Email body */
    @Deprecated
    public java.lang.String body;
    @Deprecated
    public java.util.List<Attachment> attachments;
    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public Email() {
    }
    /**
     * All-args constructor.
     * @param from From email address
     * @param to To email address
     * @param cc Cc email address
     * @param bcc Bcc email address
     * @param subject Email subject
     * @param body Email body
     * @param attachments The new value for attachments
     */
    public Email(java.lang.String from, java.lang.String to, java.lang.String cc, java.lang.String bcc, java.lang.String subject, java.lang.String body, java.util.List<Attachment> attachments) {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
    }

    public static org.apache.avro.Schema getClassSchema() {
        return SCHEMA$;
    }

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     */
    public static BinaryMessageDecoder<Email> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     */
    public static BinaryMessageDecoder<Email> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<Email>(MODEL$, SCHEMA$, resolver);
    }

    /** Deserializes a Email from a ByteBuffer. */
    public static Email fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    /**
     * Creates a new Email RecordBuilder.
     * @return A new Email RecordBuilder
     */
    public static Email.Builder newBuilder() {
        return new Email.Builder();
    }

    /**
     * Creates a new Email RecordBuilder by copying an existing Builder.
     * @param other The existing builder to copy.
     * @return A new Email RecordBuilder
     */
    public static Email.Builder newBuilder(Email.Builder other) {
        return new Email.Builder(other);
    }

    /**
     * Creates a new Email RecordBuilder by copying an existing Email instance.
     * @param other The existing instance to copy.
     * @return A new Email RecordBuilder
     */
    public static Email.Builder newBuilder(Email other) {
        return new Email.Builder(other);
    }

    /** Serializes this Email to a ByteBuffer. */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    public org.apache.avro.Schema getSchema() {
        return SCHEMA$;
    }

    // Used by DatumWriter.  Applications should not call.
    public java.lang.Object get(int field$) {
        switch (field$) {
            case 0:
                return from;
            case 1:
                return to;
            case 2:
                return cc;
            case 3:
                return bcc;
            case 4:
                return subject;
            case 5:
                return body;
            case 6:
                return attachments;
            default:
                throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value = "unchecked")
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0:
                from = (java.lang.String) value$;
                break;
            case 1:
                to = (java.lang.String) value$;
                break;
            case 2:
                cc = (java.lang.String) value$;
                break;
            case 3:
                bcc = (java.lang.String) value$;
                break;
            case 4:
                subject = (java.lang.String) value$;
                break;
            case 5:
                body = (java.lang.String) value$;
                break;
            case 6:
                attachments = (java.util.List<Attachment>) value$;
                break;
            default:
                throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    /**
     * Gets the value of the 'from' field.
     * @return From email address
     */
    public java.lang.String getFrom() {
        return from;
    }

    /**
     * Sets the value of the 'from' field.
     * From email address
     * @param value the value to set.
     */
    public void setFrom(java.lang.String value) {
        this.from = value;
    }

    /**
     * Gets the value of the 'to' field.
     * @return To email address
     */
    public java.lang.String getTo() {
        return to;
    }

    /**
     * Sets the value of the 'to' field.
     * To email address
     * @param value the value to set.
     */
    public void setTo(java.lang.String value) {
        this.to = value;
    }

    /**
     * Gets the value of the 'cc' field.
     * @return Cc email address
     */
    public java.lang.String getCc() {
        return cc;
    }

    /**
     * Sets the value of the 'cc' field.
     * Cc email address
     * @param value the value to set.
     */
    public void setCc(java.lang.String value) {
        this.cc = value;
    }

    /**
     * Gets the value of the 'bcc' field.
     * @return Bcc email address
     */
    public java.lang.String getBcc() {
        return bcc;
    }

    /**
     * Sets the value of the 'bcc' field.
     * Bcc email address
     * @param value the value to set.
     */
    public void setBcc(java.lang.String value) {
        this.bcc = value;
    }

    /**
     * Gets the value of the 'subject' field.
     * @return Email subject
     */
    public java.lang.String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the 'subject' field.
     * Email subject
     * @param value the value to set.
     */
    public void setSubject(java.lang.String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the 'body' field.
     * @return Email body
     */
    public java.lang.String getBody() {
        return body;
    }

    /**
     * Sets the value of the 'body' field.
     * Email body
     * @param value the value to set.
     */
    public void setBody(java.lang.String value) {
        this.body = value;
    }

    /**
     * Gets the value of the 'attachments' field.
     * @return The value of the 'attachments' field.
     */
    public java.util.List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * Sets the value of the 'attachments' field.
     * @param value the value to set.
     */
    public void setAttachments(java.util.List<Attachment> value) {
        this.attachments = value;
    }

    @Override
    public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @Override
    public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    /**
     * RecordBuilder for Email instances.
     */
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Email>
            implements org.apache.avro.data.RecordBuilder<Email> {

        /** From email address */
        private java.lang.String from;
        /** To email address */
        private java.lang.String to;
        /** Cc email address */
        private java.lang.String cc;
        /** Bcc email address */
        private java.lang.String bcc;
        /** Email subject */
        private java.lang.String subject;
        /** Email body */
        private java.lang.String body;
        private java.util.List<Attachment> attachments;

        /** Creates a new Builder */
        private Builder() {
            super(SCHEMA$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         * @param other The existing Builder to copy.
         */
        private Builder(Email.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.from)) {
                this.from = data().deepCopy(fields()[0].schema(), other.from);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.to)) {
                this.to = data().deepCopy(fields()[1].schema(), other.to);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.cc)) {
                this.cc = data().deepCopy(fields()[2].schema(), other.cc);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.bcc)) {
                this.bcc = data().deepCopy(fields()[3].schema(), other.bcc);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.subject)) {
                this.subject = data().deepCopy(fields()[4].schema(), other.subject);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.body)) {
                this.body = data().deepCopy(fields()[5].schema(), other.body);
                fieldSetFlags()[5] = true;
            }
            if (isValidValue(fields()[6], other.attachments)) {
                this.attachments = data().deepCopy(fields()[6].schema(), other.attachments);
                fieldSetFlags()[6] = true;
            }
        }

        /**
         * Creates a Builder by copying an existing Email instance
         * @param other The existing instance to copy.
         */
        private Builder(Email other) {
            super(SCHEMA$);
            if (isValidValue(fields()[0], other.from)) {
                this.from = data().deepCopy(fields()[0].schema(), other.from);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.to)) {
                this.to = data().deepCopy(fields()[1].schema(), other.to);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.cc)) {
                this.cc = data().deepCopy(fields()[2].schema(), other.cc);
                fieldSetFlags()[2] = true;
            }
            if (isValidValue(fields()[3], other.bcc)) {
                this.bcc = data().deepCopy(fields()[3].schema(), other.bcc);
                fieldSetFlags()[3] = true;
            }
            if (isValidValue(fields()[4], other.subject)) {
                this.subject = data().deepCopy(fields()[4].schema(), other.subject);
                fieldSetFlags()[4] = true;
            }
            if (isValidValue(fields()[5], other.body)) {
                this.body = data().deepCopy(fields()[5].schema(), other.body);
                fieldSetFlags()[5] = true;
            }
            if (isValidValue(fields()[6], other.attachments)) {
                this.attachments = data().deepCopy(fields()[6].schema(), other.attachments);
                fieldSetFlags()[6] = true;
            }
        }

        /**
         * Gets the value of the 'from' field.
         * From email address
         * @return The value.
         */
        public java.lang.String getFrom() {
            return from;
        }

        /**
         * Sets the value of the 'from' field.
         * From email address
         * @param value The value of 'from'.
         * @return This builder.
         */
        public Email.Builder setFrom(java.lang.String value) {
            validate(fields()[0], value);
            this.from = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'from' field has been set.
         * From email address
         * @return True if the 'from' field has been set, false otherwise.
         */
        public boolean hasFrom() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'from' field.
         * From email address
         * @return This builder.
         */
        public Email.Builder clearFrom() {
            from = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'to' field.
         * To email address
         * @return The value.
         */
        public java.lang.String getTo() {
            return to;
        }

        /**
         * Sets the value of the 'to' field.
         * To email address
         * @param value The value of 'to'.
         * @return This builder.
         */
        public Email.Builder setTo(java.lang.String value) {
            validate(fields()[1], value);
            this.to = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'to' field has been set.
         * To email address
         * @return True if the 'to' field has been set, false otherwise.
         */
        public boolean hasTo() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'to' field.
         * To email address
         * @return This builder.
         */
        public Email.Builder clearTo() {
            to = null;
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'cc' field.
         * Cc email address
         * @return The value.
         */
        public java.lang.String getCc() {
            return cc;
        }

        /**
         * Sets the value of the 'cc' field.
         * Cc email address
         * @param value The value of 'cc'.
         * @return This builder.
         */
        public Email.Builder setCc(java.lang.String value) {
            validate(fields()[2], value);
            this.cc = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'cc' field has been set.
         * Cc email address
         * @return True if the 'cc' field has been set, false otherwise.
         */
        public boolean hasCc() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'cc' field.
         * Cc email address
         * @return This builder.
         */
        public Email.Builder clearCc() {
            cc = null;
            fieldSetFlags()[2] = false;
            return this;
        }

        /**
         * Gets the value of the 'bcc' field.
         * Bcc email address
         * @return The value.
         */
        public java.lang.String getBcc() {
            return bcc;
        }

        /**
         * Sets the value of the 'bcc' field.
         * Bcc email address
         * @param value The value of 'bcc'.
         * @return This builder.
         */
        public Email.Builder setBcc(java.lang.String value) {
            validate(fields()[3], value);
            this.bcc = value;
            fieldSetFlags()[3] = true;
            return this;
        }

        /**
         * Checks whether the 'bcc' field has been set.
         * Bcc email address
         * @return True if the 'bcc' field has been set, false otherwise.
         */
        public boolean hasBcc() {
            return fieldSetFlags()[3];
        }


        /**
         * Clears the value of the 'bcc' field.
         * Bcc email address
         * @return This builder.
         */
        public Email.Builder clearBcc() {
            bcc = null;
            fieldSetFlags()[3] = false;
            return this;
        }

        /**
         * Gets the value of the 'subject' field.
         * Email subject
         * @return The value.
         */
        public java.lang.String getSubject() {
            return subject;
        }

        /**
         * Sets the value of the 'subject' field.
         * Email subject
         * @param value The value of 'subject'.
         * @return This builder.
         */
        public Email.Builder setSubject(java.lang.String value) {
            validate(fields()[4], value);
            this.subject = value;
            fieldSetFlags()[4] = true;
            return this;
        }

        /**
         * Checks whether the 'subject' field has been set.
         * Email subject
         * @return True if the 'subject' field has been set, false otherwise.
         */
        public boolean hasSubject() {
            return fieldSetFlags()[4];
        }


        /**
         * Clears the value of the 'subject' field.
         * Email subject
         * @return This builder.
         */
        public Email.Builder clearSubject() {
            subject = null;
            fieldSetFlags()[4] = false;
            return this;
        }

        /**
         * Gets the value of the 'body' field.
         * Email body
         * @return The value.
         */
        public java.lang.String getBody() {
            return body;
        }

        /**
         * Sets the value of the 'body' field.
         * Email body
         * @param value The value of 'body'.
         * @return This builder.
         */
        public Email.Builder setBody(java.lang.String value) {
            validate(fields()[5], value);
            this.body = value;
            fieldSetFlags()[5] = true;
            return this;
        }

        /**
         * Checks whether the 'body' field has been set.
         * Email body
         * @return True if the 'body' field has been set, false otherwise.
         */
        public boolean hasBody() {
            return fieldSetFlags()[5];
        }


        /**
         * Clears the value of the 'body' field.
         * Email body
         * @return This builder.
         */
        public Email.Builder clearBody() {
            body = null;
            fieldSetFlags()[5] = false;
            return this;
        }

        /**
         * Gets the value of the 'attachments' field.
         * @return The value.
         */
        public java.util.List<Attachment> getAttachments() {
            return attachments;
        }

        /**
         * Sets the value of the 'attachments' field.
         * @param value The value of 'attachments'.
         * @return This builder.
         */
        public Email.Builder setAttachments(java.util.List<Attachment> value) {
            validate(fields()[6], value);
            this.attachments = value;
            fieldSetFlags()[6] = true;
            return this;
        }

        /**
         * Checks whether the 'attachments' field has been set.
         * @return True if the 'attachments' field has been set, false otherwise.
         */
        public boolean hasAttachments() {
            return fieldSetFlags()[6];
        }


        /**
         * Clears the value of the 'attachments' field.
         * @return This builder.
         */
        public Email.Builder clearAttachments() {
            attachments = null;
            fieldSetFlags()[6] = false;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Email build() {
            try {
                Email record = new Email();
                record.from = fieldSetFlags()[0] ? this.from : (java.lang.String) defaultValue(fields()[0]);
                record.to = fieldSetFlags()[1] ? this.to : (java.lang.String) defaultValue(fields()[1]);
                record.cc = fieldSetFlags()[2] ? this.cc : (java.lang.String) defaultValue(fields()[2]);
                record.bcc = fieldSetFlags()[3] ? this.bcc : (java.lang.String) defaultValue(fields()[3]);
                record.subject = fieldSetFlags()[4] ? this.subject : (java.lang.String) defaultValue(fields()[4]);
                record.body = fieldSetFlags()[5] ? this.body : (java.lang.String) defaultValue(fields()[5]);
                record.attachments = fieldSetFlags()[6] ? this.attachments : (java.util.List<Attachment>) defaultValue(fields()[6]);
                return record;
            } catch (java.lang.Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

}
