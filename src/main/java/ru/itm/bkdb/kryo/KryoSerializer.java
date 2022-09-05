package ru.itm.bkdb.kryo;

import com.esotericsoftware.kryo.kryo5.Kryo;
import com.esotericsoftware.kryo.kryo5.io.Input;
import com.esotericsoftware.kryo.kryo5.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoSerializer {
    private static final ThreadLocalKryoFactory factory = new ThreadLocalKryoFactory();

    public static byte[] serialize(Object object) {
        Kryo kryo = factory.getKryo();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);
        kryo.writeClassAndObject(output, object);
        output.flush();
        output.close();
        byte[] b = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("------------------------------------Input = " + b.length);
        byte[] bb = new byte[0];
        try {
            bb = CompressObject.writeCompressObject(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("; Output = " + bb.length + "-----------------------------");
        return b;
    }

    public static Object deserialize(byte[] b) {
        if (b.length == 0) {
            return null;
        }
        Input input = new Input(new ByteArrayInputStream(b));
        Kryo kryo = factory.getKryo();
        return kryo.readClassAndObject(input);
    }


}
