PGDMP     4                    z           db_shuf    14.2    14.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    19083    db_shuf    DATABASE     k   CREATE DATABASE db_shuf WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE db_shuf;
                hp    false            �            1259    51854    contrattypes    TABLE     N   CREATE TABLE public.contrattypes (
    type character varying(25) NOT NULL
);
     DROP TABLE public.contrattypes;
       public         heap    hp    false            �            1259    51860    offers    TABLE     �   CREATE TABLE public.offers (
    id integer NOT NULL,
    description character varying(255) NOT NULL,
    profile character varying(50) NOT NULL,
    type character varying(25)
);
    DROP TABLE public.offers;
       public         heap    hp    false            �            1259    51859    offers_id_seq    SEQUENCE     �   CREATE SEQUENCE public.offers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.offers_id_seq;
       public          hp    false    213                       0    0    offers_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.offers_id_seq OWNED BY public.offers.id;
          public          hp    false    212            �            1259    19085    users    TABLE       CREATE TABLE public.users (
    id integer NOT NULL,
    "dateCreated" date DEFAULT CURRENT_DATE NOT NULL,
    name character varying(50),
    login character varying(50) NOT NULL,
    passhash character varying(250) NOT NULL,
    email character varying(50)
);
    DROP TABLE public.users;
       public         heap    hp    false            �            1259    19084    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          hp    false    210                       0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          hp    false    209            g           2604    51863 	   offers id    DEFAULT     f   ALTER TABLE ONLY public.offers ALTER COLUMN id SET DEFAULT nextval('public.offers_id_seq'::regclass);
 8   ALTER TABLE public.offers ALTER COLUMN id DROP DEFAULT;
       public          hp    false    213    212    213            e           2604    19088    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          hp    false    210    209    210            �          0    51854    contrattypes 
   TABLE DATA           ,   COPY public.contrattypes (type) FROM stdin;
    public          hp    false    211   9                  0    51860    offers 
   TABLE DATA           @   COPY public.offers (id, description, profile, type) FROM stdin;
    public          hp    false    213   V       �          0    19085    users 
   TABLE DATA           P   COPY public.users (id, "dateCreated", name, login, passhash, email) FROM stdin;
    public          hp    false    210   s       	           0    0    offers_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.offers_id_seq', 1, false);
          public          hp    false    212            
           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 1, true);
          public          hp    false    209            �      x������ � �             x������ � �      �   P   x�3�4202�50�50���L�H�UN�+Í�8�L�,L���L�-�R,�-,��SM̍�M��8�S� J�b���� }��     