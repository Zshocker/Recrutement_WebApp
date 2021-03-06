PGDMP                         z            db_shuf    14.2    14.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    44147    db_shuf    DATABASE     c   CREATE DATABASE db_shuf WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_France.1252';
    DROP DATABASE db_shuf;
                hp    false            ?            1259    44170    postulation    TABLE     	  CREATE TABLE public.postulation (
    id integer NOT NULL,
    datepost date NOT NULL,
    nom character varying(50) NOT NULL,
    prenom character varying(50) NOT NULL,
    cv character varying NOT NULL,
    lettre character varying,
    offer integer NOT NULL
);
    DROP TABLE public.postulation;
       public         heap    hp    false            ?            1259    44169    Postulation_id_seq    SEQUENCE     ?   CREATE SEQUENCE public."Postulation_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public."Postulation_id_seq";
       public          hp    false    215                       0    0    Postulation_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public."Postulation_id_seq" OWNED BY public.postulation.id;
          public          hp    false    214            ?            1259    44148    contrattypes    TABLE     N   CREATE TABLE public.contrattypes (
    type character varying(25) NOT NULL
);
     DROP TABLE public.contrattypes;
       public         heap    hp    false            ?            1259    44151    offers    TABLE     ?   CREATE TABLE public.offers (
    id integer NOT NULL,
    description character varying(255) NOT NULL,
    profile character varying(50) NOT NULL,
    type character varying(25),
    creator integer NOT NULL
);
    DROP TABLE public.offers;
       public         heap    hp    false            ?            1259    44154    offers_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.offers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.offers_id_seq;
       public          hp    false    210                       0    0    offers_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.offers_id_seq OWNED BY public.offers.id;
          public          hp    false    211            ?            1259    44155    users    TABLE       CREATE TABLE public.users (
    id integer NOT NULL,
    datecreated date DEFAULT CURRENT_DATE NOT NULL,
    name character varying(50),
    login character varying(50) NOT NULL,
    passhash character varying(250) NOT NULL,
    email character varying(50)
);
    DROP TABLE public.users;
       public         heap    hp    false            ?            1259    44159    users_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          hp    false    212                       0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          hp    false    213            j           2604    44160 	   offers id    DEFAULT     f   ALTER TABLE ONLY public.offers ALTER COLUMN id SET DEFAULT nextval('public.offers_id_seq'::regclass);
 8   ALTER TABLE public.offers ALTER COLUMN id DROP DEFAULT;
       public          hp    false    211    210            m           2604    44173    postulation id    DEFAULT     r   ALTER TABLE ONLY public.postulation ALTER COLUMN id SET DEFAULT nextval('public."Postulation_id_seq"'::regclass);
 =   ALTER TABLE public.postulation ALTER COLUMN id DROP DEFAULT;
       public          hp    false    214    215    215            k           2604    44161    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          hp    false    213    212            ?          0    44148    contrattypes 
   TABLE DATA           ,   COPY public.contrattypes (type) FROM stdin;
    public          hp    false    209          ?          0    44151    offers 
   TABLE DATA           I   COPY public.offers (id, description, profile, type, creator) FROM stdin;
    public          hp    false    210   1       ?          0    44170    postulation 
   TABLE DATA           S   COPY public.postulation (id, datepost, nom, prenom, cv, lettre, offer) FROM stdin;
    public          hp    false    215   ?       ?          0    44155    users 
   TABLE DATA           N   COPY public.users (id, datecreated, name, login, passhash, email) FROM stdin;
    public          hp    false    212   ?       	           0    0    Postulation_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."Postulation_id_seq"', 1, false);
          public          hp    false    214            
           0    0    offers_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.offers_id_seq', 9, true);
          public          hp    false    211                       0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 5, true);
          public          hp    false    213            ?      x?KN??JNI?????? ?      ?   ?   x?}?A?0E??S??H?ѽ7p??M?h??)??[?a???ߛ)%?4??l???>?QG?*Tn?ML:t?͹0/?1r[?9??6F??$(1Q???/KWvX?_?vWy?W???YG?>?l?P?????²?uǔ?????
U?RavY6      ?      x?????? ? ?      ?   ?   x???M? ??p
/?f?Rv??[7?b!I???MJ?ƅ7?7?{?B?U?1????.????4"OhV?<?f???6?h?~@???V??HB	qN??4???G?/ť??Z???R????';??l???jK????B޼??\?p?R??N??	ۅY?     