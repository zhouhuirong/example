package linked;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class House {
    private String address;

    public House(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                '}';
    }
}
